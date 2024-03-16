package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.dto.request.PostingRequest;
import practicemsa.communityservice.dto.util.Converter;
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

    @Transactional
    public Posting save(Posting posting, List<Video> videoList, List<Photo> photoList) {

        photoList.forEach(photo -> photoService.findAndSetPosting(photo,posting));
        videoList.forEach(video -> videoService.findAndSetPosting(video,posting));

        Posting savePosting = postingRepository.save(posting);
        posting.setVideoList(videoList);
        posting.setPhotoList(photoList);

        return savePosting;
    }

    @Transactional
    public Posting save(PostingRequest postingRequest) {

        Posting posting = Converter.postingFromPostingRequest(postingRequest);
        List<Photo> photoList = Converter.photoListFromPhotoRequestList(postingRequest.getPhotoRequestList());
        List<Video> videoList = Converter.videoListFromVideoRequestList(postingRequest.getVideoRequestList());
        Posting savePosting = save(posting, videoList, photoList);
        return savePosting;

    }
}