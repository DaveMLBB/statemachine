package co.develhope.statemachine.models.dto;

import co.develhope.statemachine.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String username;
    private String email;
    private String website;
    private List<Role> roles;

}
