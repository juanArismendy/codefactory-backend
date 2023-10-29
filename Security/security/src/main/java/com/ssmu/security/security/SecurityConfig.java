package com.ssmu.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssmu.security.services.UserDetailServiceImpl;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;;

    // @Autowired
    // private UserDetailServiceImpl userDetailServiceImpl;

    // @Bean
    // UserDetailServiceImpl userDetailsService() {
    // return userDetailServiceImpl;
    // }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http
        // .csrf().disable() // (2)
        // .authorizeHttpRequests((authorize) -> authorize
        // .requestMatchers("/publico/**").permitAll()
        // .requestMatchers("/admin/**").hasRole("ADMIN")
        // .anyRequest().authenticated())
        // .cors(withDefaults())
        // .addFilterBefore(jwtRequestFilter,
        // UsernamePasswordAuthenticationFilter.class)
        // .sessionManagement((session) -> session
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // ;

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        // .requestMatchers("/**").permitAll()
                        .requestMatchers("/api_v1/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api_v1/auth/**").permitAll()
                        .requestMatchers("/api_v1/test/**").permitAll()
                        .anyRequest().authenticated())
                // .cors(Customizer.withDefaults())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // .csrf(AbstractHttpConfigurer::disable);

        // http.formLogin(Customizer.withDefaults());

        // http.httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        System.out.println("authenticationConfiguration: " + authenticationConfiguration.toString());
        return authenticationConfiguration.getAuthenticationManager();
    }

}
