package com.ssmu.security.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssmu.security.domain.entities.AppUser;
import com.ssmu.security.domain.use_cases.GetAllUsers;
import com.ssmu.security.infrastructure.repositories.UserRepository;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private GetAllUsers getAllUsers;
    // @Autowired
    // private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean login(String username, String password) {
        List<AppUser> users = getAllUsers.call(null);
        for (AppUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }



}
