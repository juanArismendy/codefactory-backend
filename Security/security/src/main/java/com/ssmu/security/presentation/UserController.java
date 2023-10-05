package com.ssmu.security.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssmu.security.domain.entities.AppUser;
import com.ssmu.security.domain.use_cases.GetAllUsers;
// import com.ssmu.security.infrastructure.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private GetAllUsers getAllUsers;
    // @Autowired
    // private UserRepository userRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AppUser> listar() {
        return getAllUsers.call(null);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public AppUser buscar(Long id) {
    //     return userRepository.findById(id).get();
    // }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // public void deletar(Long id) {
    //     userRepository.deleteById(id);
    // }

    // @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    // public void atualizar(Long id, AppUser user) {
    //     user.setId(id);
    //     userRepository.save(user);
    // }

    // @RequestMapping(value = "/", method = RequestMethod.POST)
    // public void inserir(AppUser user) {
    //     userRepository.save(user);
    // }

}
