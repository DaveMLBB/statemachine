package co.develhope.statemachine.payloads.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 15, message = " must have a minimum of 3 characters and a maximum of 15 ")
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 20,message = " must have a minimum of 8 characters and a maximum of 20 ")
    private String password;

}
