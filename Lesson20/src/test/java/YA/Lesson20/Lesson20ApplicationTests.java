package YA.Lesson20;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import YA.Lesson20.DAO.BucketRepo;
import YA.Lesson20.DAO.PeriodicalRepo;
import YA.Lesson20.DAO.UserRepo;
import YA.Lesson20.domain.Bucket;
import YA.Lesson20.domain.Periodical;
import YA.Lesson20.domain.User;
import YA.Lesson20.domain.UserRole;
import YA.Lesson20.service.BucketService;
import YA.Lesson20.service.PeriodicalService;
import YA.Lesson20.service.UserService;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lesson20ApplicationTests {

    @Autowired
    private UserService userService;


    @MockBean
    private UserRepo userRepository;

    @Autowired
    PeriodicalService periodicalService;

    @MockBean
    PeriodicalRepo periodicalRepo;

    @Autowired
    BucketService bucketService;

    @MockBean
    BucketRepo bucketRepo;

    @Test
    public void testSave() {
        User user = new User(1, "new@new5", "new3", "user3", UserRole.ROLE_USER, "1");
        user.setPasswordConfirm(user.getPassword());
        when(userRepository.save(any())).thenReturn(user);
        userService.save(user);
    }

    @Test
    public void testFindByEmailNotFound() {
        User user = new User("new@new", "new1", "user1", UserRole.ROLE_USER, "1");
        when(userRepository.findByEmail("new@new")).thenReturn(Optional.of(user));
        userService.findByEmail("new@new");
    }

    @Test
    public void testSavePeriodical() {
        Periodical periodical = new Periodical();
        periodical.setName("1");
        periodical.setDescription("1");
        periodical.setEncodedImage("1");
        periodical.setPrice(1d);

        when(periodicalRepo.save(any())).thenReturn(periodical);
        periodicalService.save(periodical);
    }

    @Test
    public void testGetAllPeriodicals() {
        Periodical periodical = new Periodical();
        periodical.setName("1");
        periodical.setDescription("1");
        periodical.setEncodedImage("1");
        periodical.setPrice(1d);

        Periodical periodical2 = new Periodical();
        periodical2.setName("12");
        periodical2.setDescription("12");
        periodical2.setEncodedImage("12");
        periodical2.setPrice(12d);

        List<Periodical> periodicals = new ArrayList<>();
        periodicals.add(periodical);
        periodicals.add(periodical2);
        when(periodicalRepo.saveAll(any())).thenReturn(periodicals);
        periodicalService.getAllPeriodical();
    }

    @Test
    public void testAddToBucket() {
    User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);


        when(userRepository.save(any())).thenReturn(user);
        userService.save(user);


    Periodical periodical = new Periodical();
		periodical.setName("1");
		periodical.setDescription("1");
		periodical.setEncodedImage("1");
		periodical.setPrice(1d);

		when(periodicalRepo.save(any())).thenReturn(periodical);
        periodicalService.save(periodical);

    Date now = new Date();
    Bucket bucket = new Bucket();
		bucket.setPeriodical(periodical);
		bucket.setUser(user);
		bucket.setPurchaseDate(now);

        when(bucketRepo.save(any())).thenReturn(bucket);
        bucketService.add(bucket);
    }

}

