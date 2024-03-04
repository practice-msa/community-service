package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.repository.VideoRepository;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    @Transactional(readOnly = false)
    public Video save(Posting posting, Video video){
        Video saveVideo = videoRepository.save(video);
        saveVideo.setPosting(posting);
        return saveVideo;
    }
}
