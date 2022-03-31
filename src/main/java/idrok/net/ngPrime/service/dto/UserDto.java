package idrok.net.ngPrime.service.dto;


import idrok.net.ngPrime.entity.Roles;
import idrok.net.ngPrime.entity.User;

import java.util.Set;

public class UserDto {

    private Long id;
    private String name;
    private String lastname;
    private String login;
    private Set<Roles> roles;
    private Boolean active;


    public UserDto() {
    }

    public UserDto(Long id, String name, String lastname, String login, Set<Roles> roles, Boolean active) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.roles = roles;
        this.active = active;
    }

    public UserDto(User user) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
