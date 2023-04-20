package com.oop.btlon1.service.user;

import com.oop.btlon1.entity.user.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    void addRoleToUser(String phoneNumber, String roleName);

    Role findByName(String name);

    List<Role> getAll();
}
