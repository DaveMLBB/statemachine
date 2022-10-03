package co.develhope.statemachine.services.impl;

import co.develhope.statemachine.models.Role;
import co.develhope.statemachine.models.RoleName;
import co.develhope.statemachine.repositories.RoleRepository;
import co.develhope.statemachine.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> defaultRole() {
        List<Role> roles = new ArrayList<>();

        roles.add(roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(()->new RuntimeException("USER_ROLE_NOT_SET")));

        return roles;
    }
}
