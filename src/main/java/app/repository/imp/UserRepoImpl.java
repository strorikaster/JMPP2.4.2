package app.repository.imp;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import app.repository.UserRepo;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void editUser(User updatedUser) {
        //getEntityManager().merge(user);
        entityManager.merge(updatedUser);
        entityManager.flush();
    }

    @Override
    public User getUserById(Long id) {
        // return getEntityManager().find(User.class, id);
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.find(User.class, username);

    }
}

