package com.ecfront.easybi.base.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EZBI_ROLE")
public class EZRole {

    @Id
    @Column(name="ROLE_NAME")
    private String roleName;

    @Column(name="DESC")
    private String desc;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinTable(name = "EZBI_REF_ROLE_RESOURCE", joinColumns = {@JoinColumn(name = "ROLE_NAME")}, inverseJoinColumns = {@JoinColumn(name = "RESOURCE_NAME")})
    private List<EZResource> resources = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<EZUser> users = new ArrayList<>();

    @Column(name="ENABLE",nullable = false)
    private boolean enable;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void addResource(EZResource resource) {
        resources.add(resource);
    }

    public List<EZResource> getResources() {
        return resources;
    }

    public void setResources(List<EZResource> resources) {
        this.resources = resources;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<EZUser> getUsers() {
        return users;
    }

    public void setUsers(List<EZUser> users) {
        this.users = users;
    }
}
