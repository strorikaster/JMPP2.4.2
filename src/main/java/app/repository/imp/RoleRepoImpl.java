package app.repository.imp;


import org.springframework.stereotype.Repository;
import app.model.Role;
import app.repository.RoleRepo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleRepoImpl implements RoleRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }
}
