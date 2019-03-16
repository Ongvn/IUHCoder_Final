package iuh.team.iuhdemo.service;

import iuh.team.iuhdemo.model.user_profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("Userservice")
public interface Userservice {
    user_profile findUserByName(String name);
    Optional<user_profile> findUserById(Integer id);
    void saveUser(user_profile user);
    void delUser(user_profile user);
}
