package practicemsa.communityservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.dto.response.ApiResponse;
import practicemsa.communityservice.service.VideoService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    public ApiResponse<Video> upload(@RequestPart("file") MultipartFile file) throws IOException {
        Video video = videoService.upload(file);
        return new ApiResponse<>(true, HttpStatus.OK,video,null);
    }

    @DeleteMapping("/delete")
    public ApiResponse<String>delete(@RequestParam("url")String url){
        String result = videoService.delete(url);
        return new ApiResponse<>(true,HttpStatus.OK,result,null);
    }
}
