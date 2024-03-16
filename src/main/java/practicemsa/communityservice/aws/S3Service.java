package practicemsa.communityservice.aws;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.domain.File;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadDate(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileUrl = "https://" + bucket + ".s3.ap-northeast-2.amazonaws.com/" + fileName;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        amazonS3Client.putObject(bucket, fileName, file.getInputStream(), metadata);
        return fileUrl;
    }

    public String deleteFile(String url) {
        String result = "success";

        try {
            boolean isObjectExist = amazonS3Client.doesObjectExist(bucket, url);
            if (isObjectExist) {
                amazonS3Client.deleteObject(bucket, url);
            } else {
                result = "file not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
