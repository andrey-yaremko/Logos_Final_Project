package YA.Lesson20.service;

import YA.Lesson20.DAO.BucketRepo;
import YA.Lesson20.domain.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BucketService {

    @Autowired
    private BucketRepo bucketRepo;

    public List<Bucket> getAll(){
        return bucketRepo.findAll();
    }

    public void delete(Bucket bucket) {
        bucketRepo.delete(bucket);
    }

    public Bucket add(Bucket bucket) {
        return bucketRepo.save(bucket);
    }


}
