package iuh.team.iuhdemo.service;

import iuh.team.iuhdemo.model.user_profile;
import iuh.team.iuhdemo.repository.UserserviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("Userservice")
public class UserserviceImpl implements Userservice,UserDetailsService {
    @Autowired
    private UserserviceRepo userserviceRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public user_profile findUserByName(String name){
        return userserviceRepo.findByName(name);
    }

    @Override
    public Optional<user_profile> findUserById(Integer id){
        return userserviceRepo.findById(id);
    }

    @Override
    public void saveUser(user_profile user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userserviceRepo.save(user);
    }
    @Override
    public void delUser(user_profile user){
        userserviceRepo.delete(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        user_profile user = userserviceRepo.findByName(userName);
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("user"));
        List<GrantedAuthority> lisauth = new ArrayList<GrantedAuthority>(roles);
        return buildUserForAuthentication(user,lisauth);
    }

    private UserDetails buildUserForAuthentication(user_profile user_profile,List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.
                User(user_profile.getUsername(),user_profile.getPassword(),authorities);
    }

    @Override
    public Collection<user_profile> findAllUser(){
       return userserviceRepo.findAll();
    }
}
