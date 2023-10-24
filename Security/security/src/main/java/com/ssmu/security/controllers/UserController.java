package com.ssmu.security.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssmu.security.model.AppUser;
import com.ssmu.security.repositories.UserRepository;
import com.ssmu.security.services.GetAllUsers;
import com.ssmu.security.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // TODO agregar validaciones para todos los métodos

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AppUser> listar() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AppUser buscar(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Long id, @RequestBody AppUser user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AppUser crear(@RequestBody AppUser user) {
        System.out.println("user: " + user.toString());

        return userService.saveUser(user);

    }

}
