package practicemsa.communityservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.aws.S3Service;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.dto.response.ApiResponse;
import practicemsa.communityservice.service.PhotoService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photo")
public class PhotoController {

    private final PhotoService photoService;


    @PostMapping("/upload")
    public ApiResponse<Photo> upload(@RequestPart("file") MultipartFile file) throws IOException {
        Photo photo = photoService.upload(file);
        return new ApiResponse<>(true, HttpStatus.OK,photo,null);
    }

    @DeleteMapping("/delete")
    public ApiResponse<String>delete(@RequestParam("url")String url){
        String result = photoService.delete(url);
        return new ApiResponse<>(true,HttpStatus.OK,result,null);
    }

}
