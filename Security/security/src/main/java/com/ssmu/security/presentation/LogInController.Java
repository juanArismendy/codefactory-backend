package com.ssmu.security.presentation;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssmu.security.domain.entities.AppUser;
import com.ssmu.security.domain.entities.LoginForm;
import com.ssmu.security.domain.use_cases.GetAllUsers;

// @RestController
// @RequestMapping("/login")
// public class LoginController {

//     @Autowired
//     private GetAllUsers getAllUsers;
//     // @Autowired
//     // private UserRepository userRepository;

//     @RequestMapping(value = "/", method = RequestMethod.POST)
//     public boolean login(@RequestBody LoginForm loginForm) {

//         System.out.println("password: " + loginForm.getPassword());
//         System.out.println("username: " + loginForm.getUsername());
//         List<AppUser> users = getAllUsers.call(null);
//         for (AppUser user : users) {
//             if (user.getUsername().equals(loginForm.getUsername())
//                     && user.getPassword().equals(loginForm.getPassword())) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     @RequestMapping(value = "/logout", method = RequestMethod.GET)
//     public void logout() {
//         System.out.println("logout");
//     }

// }
