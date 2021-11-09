package app.repository;

import app.model.Role;
import app.model.User;

import java.util.List;

public interface RoleRepo {
    void addRole(Role role);

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();

    Role getDefaultRole();
}
