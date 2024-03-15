package practicemsa.communityservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;


public record ApiResponse<T>(Boolean isSuccess, HttpStatus httpStatus,
                             @JsonProperty(value = "response") T response,
                             @JsonProperty(value = "errorResponse") ErrorResponse errorResponse) {
}
