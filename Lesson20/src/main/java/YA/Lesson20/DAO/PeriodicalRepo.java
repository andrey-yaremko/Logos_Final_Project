package YA.Lesson20.DAO;

import YA.Lesson20.domain.Periodical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodicalRepo extends JpaRepository<Periodical,Long> {
}
