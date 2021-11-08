package app.repository.imp;

import app.model.User;
import org.springframework.stereotype.Repository;
import app.model.Role;
import app.repository.RoleRepo;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleRepoImpl implements RoleRepo {

    @PersistenceContext
    private EntityManager entityManager;

//    protected EntityManager getEntityManager() {
//        return this.entityManager;
//    }

    @Override
    public Role getRoleByName(String name) {
//        Role role = null;
//        try {
//            role = getEntityManager()
//                    .createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class)
//                    .setParameter("name", name)
//                    .getSingleResult();
//        } catch (Exception e) {
//            System.out.println("Роли с таким именем не существует!");
//        }
//        return role;
        return entityManager.find(Role.class, name);
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> allRoles() {
//        return getEntityManager()
//                .createQuery("select r from Role r", Role.class)
//                .getResultList();
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }
}
