package practicemsa.communityservice.dto.util;

import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.dto.request.PhotoRequest;
import practicemsa.communityservice.dto.request.PostingRequest;
import practicemsa.communityservice.dto.request.VideoRequest;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private Converter(){}

    public static Posting postingFromPostingRequest(PostingRequest postingRequest){
        return new Posting(postingRequest.getUserId(), postingRequest.getUserName(), postingRequest.getTitle(),
                postingRequest.getContent(), photoListFromPhotoRequestList(postingRequest.getPhotoRequestList()),
                null,null, null,null,null);
    }
    public static List<Photo> photoListFromPhotoRequestList(List<PhotoRequest> photoRequestList){
        List<Photo> newPhotoList=new ArrayList<>();
        photoRequestList.forEach(photoRequest->newPhotoList.add(photoFromRequestPhoto(photoRequest)));
        return newPhotoList;
    }
    public static Photo photoFromRequestPhoto(PhotoRequest photoRequest){
        return new Photo(photoRequest.getUrl());
    }

    public static List<Video> videoListFromVideoRequestList(List<VideoRequest> videoRequestList){
        List<Video> newVideoList=new ArrayList<>();
        videoRequestList.forEach(videoRequest-> newVideoList.add(videoFromRequest(videoRequest)));
        return newVideoList;
    }
    public static Video videoFromRequest(VideoRequest videoRequest){
        return new Video(videoRequest.getUrl());
    }
}
