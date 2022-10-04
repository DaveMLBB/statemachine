package co.develhope.statemachine.controllers;

import co.develhope.statemachine.models.dto.UserDto;
import co.develhope.statemachine.payloads.request.LoginRequest;
import co.develhope.statemachine.payloads.request.SignUpRequest;
import co.develhope.statemachine.payloads.request.SignupActivationRequest;
import co.develhope.statemachine.payloads.response.JwtAuthenticationResponse;
import co.develhope.statemachine.payloads.response.ApiResponse;
import co.develhope.statemachine.security.JwtTokenProvider;
import co.develhope.statemachine.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser( @Valid @RequestBody SignUpRequest signUpRequest){

        userService.existByUsername(signUpRequest.getUsername());
        userService.existByEmail(signUpRequest.getEmail());

        UserDto userDto = userService.setUserData(signUpRequest);

        ApiResponse apiResponse = new ApiResponse(true,"user registered sucessfully", userDto);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);

    }

    @PostMapping("/activation")
    public ResponseEntity<ApiResponse> signup(@Valid @RequestBody SignupActivationRequest signupActivationRequest){

        userService.activation(signupActivationRequest);
        ApiResponse apiResponse = new ApiResponse(true,"user activated sucessfully");
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.ACCEPTED);

    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@Valid @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
        return new ResponseEntity<JwtAuthenticationResponse>(jwtAuthenticationResponse, HttpStatus.OK);

    }


}
