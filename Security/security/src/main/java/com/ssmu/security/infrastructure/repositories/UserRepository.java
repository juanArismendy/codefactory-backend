package com.ssmu.security.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssmu.security.domain.entities.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

}
