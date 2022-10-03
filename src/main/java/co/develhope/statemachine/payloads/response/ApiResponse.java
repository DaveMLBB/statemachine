package co.develhope.statemachine.payloads.response;

import co.develhope.statemachine.models.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    private UserDto userDto;

    public ApiResponse() {

    }

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, UserDto userDto) {
        this.success = success;
        this.message = message;
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
