package app.service;

import app.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();

    Role getDefaultRole();

}
