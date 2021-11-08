package app.service.imp;

import app.model.Role;
import app.model.User;
import app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataLoader{

    @Autowired
    private UserRepo userRepo;

    //@Transactional
    @PostConstruct
    public void fillDataBase() {
        User user1  = new User("Alex", "root", "Alexey", "Zotov", "zotov@mail.ru",
                Stream.of(new Role("ROLE_ADMIN")).collect(Collectors.toSet()));
        User user2 = new User("Ivan", "root", "Ivan", "Petrov", "petrov@mail.ru",
                Stream.of ((new Role("ROLE_ADMIN")), (new Role("ROLE_USER"))).collect(Collectors.toSet()));
        userRepo.addUser(user1);
        userRepo.addUser(user2);
    }
}
