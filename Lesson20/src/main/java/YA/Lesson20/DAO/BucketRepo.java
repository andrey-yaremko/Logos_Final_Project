package YA.Lesson20.DAO;

import YA.Lesson20.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepo extends JpaRepository<Bucket,Integer> {
}
