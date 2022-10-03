package co.develhope.statemachine.services;

import co.develhope.statemachine.payloads.request.SignUpRequest;

public interface UserService {
    void existByUsername(String username);

    void existByEmail(String email);

    void setUserData(SignUpRequest signUpRequest);
}
