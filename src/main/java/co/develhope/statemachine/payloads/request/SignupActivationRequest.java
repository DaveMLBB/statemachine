package co.develhope.statemachine.payloads.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignupActivationRequest {

    @NotBlank
    private String activationCode;

}
