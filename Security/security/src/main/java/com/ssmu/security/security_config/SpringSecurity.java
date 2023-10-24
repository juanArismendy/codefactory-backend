// package com.ssmu.security.security_config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity(prePostEnabled = true)
// public class SpringSecurity {

//     @Autowired
//     private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Autowired
//     private JwtRequestFilter jwtRequestFilter;

//     @Bean
//     public static PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService)
//             throws Exception {
//         return http
//                 .getSharedObject(AuthenticationManagerBuilder.class)
//                 .userDetailsService(userDetailsService)
//                 .passwordEncoder(passwordEncoder())
//                 .and()
//                 .build();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable())
//                 .authorizeHttpRequests(
//                         authorizeRequests -> authorizeRequests.requestMatchers("/admins-only/**").permitAll()
//                                 .requestMatchers(HttpMethod.GET, "/**").permitAll()
//                                 .requestMatchers("/register").permitAll()
//                                 .requestMatchers("/login").permitAll()
//                                 .requestMatchers("/index").permitAll()
//                                 .requestMatchers("/users/**").permitAll()
//                                 .anyRequest()
//                                 .authenticated());

//         // http
//         // .csrf()
//         // .disable()
//         // .cors()
//         // .and()
//         // .authorizeRequests()
//         // .requestMatchers("/register").permitAll()
//         // .requestMatchers("/login").permitAll()
//         // .requestMatchers("/index").permitAll()
//         // .requestMatchers("/users").permitAll()
//         // .anyRequest().authenticated();

//         http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         auth
//                 .userDetailsService(userDetailsService)
//                 .passwordEncoder(passwordEncoder());
//     }
// }