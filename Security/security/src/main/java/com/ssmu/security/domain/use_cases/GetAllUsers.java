package com.ssmu.security.domain.use_cases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmu.security.domain.entities.AppUser;
import com.ssmu.security.infrastructure.repositories.UserRepository;

@Service
public class GetAllUsers implements BaseUseCase<Void, List<AppUser>> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> call(Void data) {
        return userRepository.findAll();
    }

}
