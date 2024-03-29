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
    public Video saveIfNotHave(String url){
        Optional<Video> videoOptional = videoRepository.findByUrl(url);
        if(videoOptional.isEmpty()){
            Video video=new Video(url);
            return save(video);
        }
        return videoOptional.get();
    }

    @Transactional
    public Video upload(MultipartFile file) {
        String url = null;
        try {
            url = s3Service.uploadDate(file);
            Video video = saveIfNotHave(url);
            return video;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public String delete(String s3object){
        String url = "https://s3-practice12.s3.ap-northeast-2.amazonaws.com/"+s3object;
        videoRepository.deleteByUrl(url);
        return s3Service.deleteFile(s3object);
    }

    public void findAndSetPosting(Video video, Posting posting) {
        Optional<Video> findVideo = videoRepository.findByUrl(video.getUrl());
        if (findVideo.isPresent()){
            video=findVideo.get();
            findVideo.get().setPosting(posting);
        }
    }
}
