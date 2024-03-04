package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.repository.PostingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    private final VideoService videoService;
    private final PhotoService photoService;

    @Transactional(readOnly = false)
    public Posting findOneById(Long id) {
        return postingRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @Transactional(readOnly = false)
    public Posting save(Posting posting, List<Video> videoList, List<Photo> photoList) {
        posting.setVideoList(videoList);
        posting.setPhotoList(photoList);
        Posting savePosting = postingRepository.save(posting);
        photoList.forEach(photo -> photoService.save(posting, photo));
        videoList.forEach(video -> videoService.save(posting, video));
        return savePosting;
    }
}