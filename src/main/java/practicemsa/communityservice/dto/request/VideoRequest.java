package practicemsa.communityservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VideoRequest {
    @NotEmpty
    private String url;

    public VideoRequest(){

    }
}
