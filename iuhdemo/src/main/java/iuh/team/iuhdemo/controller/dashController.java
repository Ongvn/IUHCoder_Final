package iuh.team.iuhdemo.controller;

import iuh.team.iuhdemo.model.submission;
import iuh.team.iuhdemo.model.user_profile;
import iuh.team.iuhdemo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class dashController {
    @Autowired
    private Userservice userservice;

    @GetMapping("/listuser")
    public Collection<user_profile> getListUser(){
        return userservice.findAllUser();
    }

    @RequestMapping(value = "/finduser/{id}",method = RequestMethod.GET)
    public Optional<user_profile> finduserbyId(@PathVariable Integer id){
        Optional<user_profile> user = userservice.findUserById(id);
        return user;
    }

    @RequestMapping(value = "/finduserprob/{id}",method = RequestMethod.GET)
    public ArrayList<submission> finduserSubmissions(@PathVariable Integer id){
        Optional<user_profile> user_profile = userservice.findUserById(id);
        ArrayList<submission> submissions = user_profile.get().getSubmissions();
        return  submissions;
    }
}
