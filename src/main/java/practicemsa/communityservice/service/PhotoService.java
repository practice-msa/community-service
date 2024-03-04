package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.repository.PhotoRepository;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Transactional(readOnly = false)
    public Photo save(Posting posting, Photo photo){
        photo.setPosting(posting);
        Photo savePhoto = photoRepository.save(photo);
        return savePhoto;
    }
}
