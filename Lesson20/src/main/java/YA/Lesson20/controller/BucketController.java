package YA.Lesson20.controller;

import YA.Lesson20.domain.Bucket;
import YA.Lesson20.domain.Periodical;
import YA.Lesson20.domain.User;
import YA.Lesson20.service.BucketService;
import YA.Lesson20.service.PeriodicalService;
import YA.Lesson20.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;


@Controller
public class BucketController {
    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;

    @Autowired
    private PeriodicalService periodicalService;

    private ModelAndView getBucketItems() {
        List<Bucket> getAll = bucketService.getAll();
        ModelAndView map = new ModelAndView("bucket");
        map.addObject("bucketItems",getAll);

        return map;

    }

    @RequestMapping(value ="/buckets", method = RequestMethod.GET)
    public ModelAndView getAllItems() {
        return getBucketItems();
    }

    @RequestMapping(value ="/bucket", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String periodicalId) {

        Periodical periodical = periodicalService.findById(Integer.parseInt(periodicalId));

        Bucket bucket = new Bucket();
        bucket.setPeriodical(periodical);
        bucket.setPurchaseDate(new Date(Calendar.getInstance().getTime().getTime()));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        User user = userService.findByEmail(userEmail);

        bucket.setUser(user);

        bucketService.add(bucket);
        return getBucketItems();
    }

    @RequestMapping(value ="/bucket", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String id) {

        bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s",""))));

        return getBucketItems();
    }





}
