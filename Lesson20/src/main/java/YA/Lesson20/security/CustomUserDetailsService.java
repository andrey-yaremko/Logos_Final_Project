package YA.Lesson20.security;

import YA.Lesson20.DAO.UserRepo;
import YA.Lesson20.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<YA.Lesson20.domain.User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
        User user = userOptional.get();
        return new CustomUserDetails(user, Collections.singletonList(user.getUserRole().toString()));
    }
        throw new UsernameNotFoundException("No user present with email:" + email);
    }
}
