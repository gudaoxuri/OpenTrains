package com.ecfront.easybi.base.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EZBI_RESOURCE")
public class EZResource {

    @Id
    @Column(name = "RESOURCE_NAME")
    private String resourceName;

    @Column(name = "METHOD", nullable = false)
    @Enumerated(EnumType.STRING)
    private MethodType method;

    @Column(name = "ACTION", nullable = false)
    private String action;

    @ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "resources", fetch = FetchType.LAZY)
    private List<EZRole> roles = new ArrayList<>();

    @Column(name = "ENABLE", nullable = false)
    private boolean enable;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public MethodType getMethod() {
        return method;
    }

    public void setMethod(MethodType method) {
        this.method = method;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<EZRole> getRoles() {
        return roles;
    }

    public void setRoles(List<EZRole> roles) {
        this.roles = roles;
    }
}
