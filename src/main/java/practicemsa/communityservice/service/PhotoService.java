package practicemsa.communityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import practicemsa.communityservice.aws.S3Service;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.repository.PhotoRepository;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    private final S3Service s3Service;

    @Transactional
    public Photo save(Photo photo){
        return photoRepository.save(photo);
    }

    @Transactional
    public Photo saveIfNotHave(String url){
        Optional<Photo> photoOptional = photoRepository.findByUrl(url);
        if(photoOptional.isEmpty()){
            Photo photo=new Photo(url);
            return save(photo);
        }
        return photoOptional.get();
    }

    @Transactional
    public Photo upload(MultipartFile file) {
        String url = null;
        try {
            url = s3Service.uploadDate(file);
            Photo photo = saveIfNotHave(url);
            return photo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public String delete(String s3object){
        String url = "https://s3-practice12.s3.ap-northeast-2.amazonaws.com/"+s3object;
        photoRepository.deleteByUrl(url);
        return s3Service.deleteFile(s3object);
    }

    @Transactional
    public void findAndSetPosting(Photo photo,Posting posting){
        Optional<Photo> findPhoto = photoRepository.findByUrl(photo.getUrl());
        if (findPhoto.isPresent()){
            findPhoto.get().setPosting(posting);
        }
    }
}
