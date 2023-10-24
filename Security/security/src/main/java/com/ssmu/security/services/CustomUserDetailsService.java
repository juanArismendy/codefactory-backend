// package com.ssmu.security.services;

// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.ssmu.security.domain.entities.AppUser;
// import com.ssmu.security.infrastructure.repositories.UserRepository;

// import java.util.List;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         AppUser user = userRepository.findByUsername(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

//         System.out.println("user repository: " + user.toString());

//         if (user != null) {
//             return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                     user.getPassword(),
//                     List.of(new SimpleGrantedAuthority[] { new SimpleGrantedAuthority("USER") }));
//         } else {
//             throw new UsernameNotFoundException("User not found with username: " + username);
//         }

//         // TODO Auto-generated method stub
//     }

// }
