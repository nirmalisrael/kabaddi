package com.julius.kabaddi.service;

import com.julius.kabaddi.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role createRole(Role role);

    String removeRole(String roleName);

    Role getRoleById(String roleName);

    List<Role> getAllRoles();
}
