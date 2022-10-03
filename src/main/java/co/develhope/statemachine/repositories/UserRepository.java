package co.develhope.statemachine.repositories;


import co.develhope.statemachine.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User existByUsername(@NotBlank String username);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User existByEmail(@NotBlank String email);
}
