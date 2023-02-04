package mk.ukim.finki.UsersService.Repository;


import mk.ukim.finki.UsersService.Model.Enumeration.Role;
import mk.ukim.finki.UsersService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    List<User> findAllByRole(Role role);
}
