package co.develhope.statemachine.services;

import co.develhope.statemachine.models.User;
import co.develhope.statemachine.models.dto.UserDto;
import co.develhope.statemachine.payloads.request.SignUpRequest;

public interface UserService {
    void existByUsername(String username);

    void existByEmail(String email);

    UserDto setUserData(SignUpRequest signUpRequest);

    UserDto toDto(User user);
}
