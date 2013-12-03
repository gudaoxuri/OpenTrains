package com.ecfront.easybi.base.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EZBI_USER")
public class EZUser {

    @Id
    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD",nullable = false)
    private String password;

    @Column(name="EMAIL",nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "EZBI_REF_USER_ROLE", joinColumns = {@JoinColumn(name = "USER_NAME")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME")})
    private List<EZRole> roles = new ArrayList<>();

    @Column(name="ENABLE",nullable = false)
    private boolean enable;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addRole(EZRole role) {
        roles.add(role);
    }

    public List<EZRole> getRoles() {
        return roles;
    }

    public void setRoles(List<EZRole> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}