package src.services.user;


import src.dto.user.UserDto;
import src.model.user.User;

public interface UserService {

    public User getUserByUName(String name);
    public User getUserByEmail(String email);

    public User saveUser(UserDto user);

    public boolean authenticate(String username, String password);
}
