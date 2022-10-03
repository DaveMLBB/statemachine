package co.develhope.statemachine.controllers;

import co.develhope.statemachine.payloads.request.SignUpRequest;
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
    public ResponseEntity<SignUpRequest> signup(@Valid @RequestBody SignUpRequest signUpRequest){

        userService.existByUsername(signUpRequest.getUsername());
        userService.existByEmail(signUpRequest.getEmail());
        userService.setUserData(signUpRequest);



        return new ResponseEntity<>(signUpRequest, HttpStatus.OK);


    }


}
