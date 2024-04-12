package com.julius.kabaddi.service.impl;

import com.julius.kabaddi.entity.Role;
import com.julius.kabaddi.repository.RoleRepository;
import com.julius.kabaddi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        if (role != null) {
            roleRepository.save(role);
            return role;
        }
        return null;
    }

    @Override
    public String removeRole(String roleName) {
        roleRepository.deleteById(roleName);
        return roleName;
    }

    @Override
    public Role getRoleById(String roleName) {
        Optional<Role> optionalRole = roleRepository.findById(roleName);
        return optionalRole.orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
