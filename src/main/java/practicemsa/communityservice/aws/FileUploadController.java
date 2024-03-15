package practicemsa.communityservice.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.dto.response.ApiResponse;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {


/*

    @PostMapping
    public ApiResponse<Photo> uploadPhoto(@RequestPart("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String fileUrl = "https://" + bucket + ".s3.ap-northeast-2.amazonaws.com/" + fileName;
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
            return new ApiResponse(true, HttpStatus.INTERNAL_SERVER_ERROR, null, null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse(false, HttpStatus.INTERNAL_SERVER_ERROR, null, null);
        }
    }

 */
}