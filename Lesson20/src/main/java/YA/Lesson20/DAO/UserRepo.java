package YA.Lesson20.DAO;

import YA.Lesson20.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

     public Optional<User> findByEmail(String email);

}
