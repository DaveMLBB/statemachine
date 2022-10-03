package co.develhope.statemachine.payloads.response;

import co.develhope.statemachine.models.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class SignUpResponse {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    private UserDto userDto;

    public SignUpResponse() {

    }

    public SignUpResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public SignUpResponse(Boolean success, String message, UserDto userDto) {
        this.success = success;
        this.message = message;
        this.userDto = userDto;
    }
}
