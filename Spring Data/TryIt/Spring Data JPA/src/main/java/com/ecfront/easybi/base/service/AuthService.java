package com.ecfront.easybi.base.service;

import com.ecfront.easybi.base.domain.EZResource;
import com.ecfront.easybi.base.domain.EZRole;
import com.ecfront.easybi.base.domain.EZUser;
import com.ecfront.easybi.base.repository.ResourceRepository;
import com.ecfront.easybi.base.repository.RoleRepository;
import com.ecfront.easybi.base.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class AuthService {

    public EZUser getUser(String userName, String email) {
        return userRepository.getByUserNameOrEmail(userName, email);
    }

    public Page<EZUser> findUsers(String userName, String email, int pageNumber, int pageSize) {
        return userRepository.findByUserNameLikeOrEmailLikeOrderByUserNameAsc(userName, email, new PageRequest(pageNumber, pageSize));
    }

    @Transactional
    public EZUser saveOrUpdateUser(EZUser user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userName) {
        userRepository.delete(userName);
    }

    @Transactional
    public void deleteUsers() {
        userRepository.deleteAll();
    }

    public EZRole getRole(String roleName) {
        return roleRepository.findOne(roleName);
    }

    public Page<EZRole> findRoles(String roleName, int pageNumber, int pageSize) {
        return roleRepository.findByRoleNameLikeOrderByRoleNameAsc(roleName, new PageRequest(pageNumber, pageSize));
    }

    @Transactional
    public EZRole saveOrUpdateRole(EZRole role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(String roleName) {
        roleRepository.delete(roleName);
    }

    @Transactional
    public void deleteRoles() {
        roleRepository.deleteAll();
    }

    public EZResource getResource(String resourceName) {
        return resourceRepository.findOne(resourceName);
    }

    public Page<EZResource> findResources(String resourceName, int pageNumber, int pageSize) {
        return resourceRepository.findByResourceNameLikeOrderByResourceNameAsc(resourceName, new PageRequest(pageNumber, pageSize));
    }

    @Transactional
    public EZResource saveOrUpdateResource(EZResource Resource) {
        return resourceRepository.save(Resource);
    }

    @Transactional
    public void deleteResource(String resourceName) {
        resourceRepository.delete(resourceName);
    }

    @Transactional
    public void deleteResources() {
        resourceRepository.deleteAll();
    }

    @Inject
    private UserRepository userRepository;
    @Inject
    private RoleRepository roleRepository;
    @Inject
    private ResourceRepository resourceRepository;
}
