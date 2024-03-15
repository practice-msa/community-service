package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.aws.S3Service;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.repository.VideoRepository;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    private final S3Service s3Service;
    @Transactional
    public Video save(Video video){
        return videoRepository.save(video);
    }

    @Transactional
    public Optional<Video> saveIfNotHave(String url){
        Optional<Video> videoOptional = videoRepository.findByUrl(url);
        if(videoOptional.isEmpty()){
            Video video=new Video(url);
            return Optional.ofNullable(save(video));
        }
        return videoOptional;
    }

    @Transactional
    public Video upload(MultipartFile file) {
        String url = null;
        try {
            url = s3Service.uploadDate(file);
            Optional<Video> videoOptional = saveIfNotHave(url);
            return videoOptional.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
