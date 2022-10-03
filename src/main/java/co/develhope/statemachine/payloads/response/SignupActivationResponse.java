package co.develhope.statemachine.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupActivationResponse {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    public SignupActivationResponse() {

    }

    public SignupActivationResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
