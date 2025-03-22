package src.repositories.user;

import org.springframework.data.repository.CrudRepository;
import src.model.user.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByuName(String name);
    User findUserByuEmail(String email);
}
