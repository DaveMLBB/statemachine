package co.develhope.statemachine.controllers;

import co.develhope.statemachine.models.dto.UserDto;
import co.develhope.statemachine.payloads.request.SignUpRequest;
import co.develhope.statemachine.payloads.request.SignupActivationRequest;
import co.develhope.statemachine.payloads.response.SignUpResponse;
import co.develhope.statemachine.payloads.response.SignupActivationResponse;
import co.develhope.statemachine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@Valid @RequestBody SignUpRequest signUpRequest){

        userService.existByUsername(signUpRequest.getUsername());
        userService.existByEmail(signUpRequest.getEmail());

        UserDto userDto = userService.setUserData(signUpRequest);

        SignUpResponse signUpResponse = new SignUpResponse(true,"user registered sucessfully", userDto);

        return new ResponseEntity<SignUpResponse>(signUpResponse, HttpStatus.CREATED);

    }

    @PostMapping("/activation")
    public ResponseEntity<SignupActivationResponse> signup(@RequestBody SignupActivationRequest signupActivationRequest){

        userService.activation(signupActivationRequest);
        SignupActivationResponse signupActivationResponse = new SignupActivationResponse(true,"user activated sucessfully");
        return new ResponseEntity<SignupActivationResponse>(signupActivationResponse,HttpStatus.ACCEPTED);

    }


}
