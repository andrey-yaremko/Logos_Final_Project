package YA.Lesson20.DAO;

import YA.Lesson20.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    List<User>findByEmail(Spring email);

}
