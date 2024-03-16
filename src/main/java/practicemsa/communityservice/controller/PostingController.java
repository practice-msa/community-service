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
@RequestMapping("/posting")
public class PostingController {

    private final PostingService postingService;


    @PostMapping
    public ApiResponse<Posting> savePosting(@RequestBody @Valid PostingRequest postingRequest, BindingResult errors) {
        if (errors.hasErrors())
            return new ApiResponse<Posting>(false, HttpStatus.BAD_REQUEST, null, null);
        Posting posting = postingService.save(postingRequest);
        return new ApiResponse<>(true,HttpStatus.OK, posting, null);
    }

    @GetMapping("{id}")
    public ApiResponse<Posting>findById(@PathVariable("id")Long id){
        Posting posting = postingService.findOneById(id);

        return new ApiResponse<>(true,HttpStatus.OK,posting,null);

    }




}
