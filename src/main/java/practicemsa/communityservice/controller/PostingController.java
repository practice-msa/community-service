package practicemsa.communityservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practicemsa.communityservice.domain.Photo;
import practicemsa.communityservice.domain.Posting;
import practicemsa.communityservice.domain.Video;
import practicemsa.communityservice.dto.request.PostingRequest;
import practicemsa.communityservice.dto.response.ApiResponse;
import practicemsa.communityservice.dto.util.Converter;
import practicemsa.communityservice.service.PostingService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;

    @PostMapping("/posting")
    public ApiResponse<Posting> savePosting(@RequestBody @Valid PostingRequest postingRequest, BindingResult errors) {
        if (errors.hasErrors())
            return new ApiResponse<Posting>(false, HttpStatus.BAD_REQUEST, null, null);
        Posting posting = Converter.postingFromPostingRequest(postingRequest);
        List<Photo> photoList = Converter.photoListFromPhotoRequestList(postingRequest.getPhotoRequestList());
        List<Video> videoList = Converter.videoListFromVideoRequestList(postingRequest.getVideoRequestList());
        postingService.save(posting, videoList, photoList);
        return new ApiResponse(true,HttpStatus.OK, posting, null);
    }



}
