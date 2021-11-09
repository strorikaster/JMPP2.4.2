package app.service.imp;

import app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import app.model.User;
import app.repository.UserRepo;
import app.service.UserService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;


//    public void UserServiceImpl(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }



    @Override
    @Transactional
    public void addUser(User user) {
        userRepo.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userRepo.editUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.getUserByUsername(username);
    }
}
