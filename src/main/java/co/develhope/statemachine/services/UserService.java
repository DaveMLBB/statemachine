package co.develhope.statemachine.services;

import co.develhope.statemachine.models.User;
import co.develhope.statemachine.models.dto.UserDto;
import co.develhope.statemachine.payloads.request.SignUpRequest;
import co.develhope.statemachine.payloads.request.SignupActivationRequest;

public interface UserService {
    void existByUsername(String username);

    void existByEmail(String email);

    UserDto setUserData(SignUpRequest signUpRequest);

    UserDto toDto(User user);

    void activation(SignupActivationRequest signupActivationRequest);
}
