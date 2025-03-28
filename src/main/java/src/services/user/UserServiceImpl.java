package src.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import src.dto.user.UserDto;
import src.model.user.User;
import src.repositories.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        var user = new User(userDto.getUName(), this.passwordEncoder.encode(userDto.getUPassword()), userDto.getUEmail());
        this.userRepository.save(user);
    }

    @Override
    public User getUserByUName(String uName) {
        return this.userRepository.findUserByuName(uName);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findUserByuEmail(email);
    }

    @Override
    public boolean authenticate(String username, String password) {
        var user = this.userRepository.findUserByuName(username);
        if (user == null) {
            return false;
        }
        return this.passwordEncoder.matches(password, user.getPassword());
    }

}
