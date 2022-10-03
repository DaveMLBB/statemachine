package co.develhope.statemachine.services.impl;

import co.develhope.statemachine.exceptions.BlogException;
import co.develhope.statemachine.models.User;
import co.develhope.statemachine.payloads.request.SignUpRequest;
import co.develhope.statemachine.repositories.UserRepository;
import co.develhope.statemachine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void existByUsername(String username) {

       User user = userRepository.existByUsername(username);

        if (!user.getUsername().isEmpty()){
            throw new BlogException(HttpStatus.BAD_REQUEST, "Username is already taken");
        }
    }

    @Override
    public void existByEmail(String email) {

        User user = userRepository.existByEmail(email);

        if (!user.getEmail().isEmpty()){
            throw new BlogException(HttpStatus.BAD_REQUEST, "email is already in use");
        }
    }

    @Override
    public void setUserData(SignUpRequest signUpRequest) {
       //TODO user
        User user = new User();
        signUpRequest.getUsername().toLowerCase();
        signUpRequest.getEmail().toLowerCase();


    }
}
