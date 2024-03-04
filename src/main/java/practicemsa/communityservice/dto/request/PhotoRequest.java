package practicemsa.communityservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@ToString
public class PhotoRequest {

    @NotEmpty
    private String url;

    public PhotoRequest(){

    }
}
