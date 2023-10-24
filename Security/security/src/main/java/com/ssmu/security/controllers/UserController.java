package com.ssmu.security.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssmu.security.domain.entities.AppUser;
import com.ssmu.security.infrastructure.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //TODO agregar validaciones para todos los métodos

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
            System.out.println("Test>>>>");
        return  "test ok";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AppUser> listar() {
    
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AppUser buscar(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void atualizar(@PathVariable Long id, @RequestBody AppUser user) {
        user.setId(id);
        userRepository.save(user);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AppUser crear(@RequestBody AppUser user) {
        System.out.println("user: " + user.toString());

        return userRepository.save(user);

    }

}
