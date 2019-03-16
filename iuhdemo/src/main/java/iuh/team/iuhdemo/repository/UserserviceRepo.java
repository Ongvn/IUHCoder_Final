package iuh.team.iuhdemo.repository;

import iuh.team.iuhdemo.model.user_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository("UserserviceRepo")
public interface UserserviceRepo extends JpaRepository<user_profile,Integer> {
    user_profile findByName(String name);
    Optional<user_profile> findById(Integer id);
}
