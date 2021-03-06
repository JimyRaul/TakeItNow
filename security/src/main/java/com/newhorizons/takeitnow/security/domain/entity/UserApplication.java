package com.newhorizons.takeitnow.security.domain.entity;

import java.util.List;

public class UserApplication {
    private Long id;
    private String username;
    private String password;
    private Boolean active;
    private String firstName;
    private String lastName;
    private String email;

    private List<RoleApplication> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleApplication> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleApplication> roles) {
        this.roles = roles;
    }
}
