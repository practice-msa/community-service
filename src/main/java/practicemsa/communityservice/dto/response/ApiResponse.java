package practicemsa.communityservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.ErrorResponse;




public record ApiResponse<T>(Boolean isSuccess, @JsonProperty(value = "response") T response,
                             @JsonProperty(value = "errorResponse") ErrorResponse errorResponse) {


}
