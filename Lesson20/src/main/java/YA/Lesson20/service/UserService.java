package YA.Lesson20.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import YA.Lesson20.DAO.UserRepo;
import YA.Lesson20.domain.User;
import YA.Lesson20.domain.UserRole;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        logger.info("Register new user {} : " + user);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }

    public  User findByEmail(String email) {
        logger.info("Get user {} by email: " + email);
        return userRepository.findByEmail(email).get();
    }

}