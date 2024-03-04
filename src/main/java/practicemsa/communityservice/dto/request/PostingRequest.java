package practicemsa.communityservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;
import practicemsa.communityservice.domain.Video;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
public class PostingRequest {

    @NotNull
    private Long userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    private List<PhotoRequest>photoRequestList=new ArrayList<>();

    private List<VideoRequest>videoRequestList=new ArrayList<>();
    public PostingRequest(){

    }
}
