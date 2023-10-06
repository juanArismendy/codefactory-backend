package com.ssmu.security.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
    // private boolean active;
    private String email;

    public AppUser() {
    }

    public AppUser(Long id, String username, String password, String role, boolean active, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;

        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // public boolean isActive() {
    // return active;
    // }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public void setActive(boolean active) {
    // this.active = active;
    // }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Override
    public String toString() {
        return "AppUser [email=" + email + ", id=" + id + ", password=" + password + ", role=" + role + ", username="
                + username + "]";
    }
}
