package co.develhope.statemachine.services.impl;

import co.develhope.statemachine.exceptions.BlogException;
import co.develhope.statemachine.models.Role;
import co.develhope.statemachine.models.User;
import co.develhope.statemachine.models.dto.UserDto;
import co.develhope.statemachine.payloads.request.SignUpRequest;
import co.develhope.statemachine.payloads.request.SignupActivationRequest;
import co.develhope.statemachine.repositories.UserRepository;
import co.develhope.statemachine.services.MailNotificationService;
import co.develhope.statemachine.services.RoleService;
import co.develhope.statemachine.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MailNotificationService mailNotificationService;

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
    public UserDto setUserData(SignUpRequest signUpRequest) {

        User user = new User();
        user.setEmail(signUpRequest.getEmail().toLowerCase());
        user.setUsername(signUpRequest.getUsername().toLowerCase());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        List<Role> userRoles = roleService.defaultRole();
        user.setRoles(userRoles);
        user.setActivationCode(UUID.randomUUID().toString());
        mailNotificationService.sendActivationEmail(user);
        userRepository.save(user);
        UserService userService = null;
        UserDto userDto = userService.toDto(user);

        return userDto;

    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;

    }

    @Override
    public void activation(SignupActivationRequest signupActivationRequest) {

        User user = userRepository.findByActivationCode(signupActivationRequest.getActivationCode());
        if (user==null) throw  new BlogException(HttpStatus.NOT_FOUND, "User not found");
        user.setIsActive(true);
        user.setActivationCode(null);
        userRepository.save(user);
    }
}
