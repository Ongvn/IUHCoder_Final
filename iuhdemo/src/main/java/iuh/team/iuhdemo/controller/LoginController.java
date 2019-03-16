package iuh.team.iuhdemo.controller;

import iuh.team.iuhdemo.repository.UserserviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserserviceRepo userserviceRepo;

    @GetMapping("/login")
    public String login(){
        String ans = "200 Ok";
        return ans;
    }
}
