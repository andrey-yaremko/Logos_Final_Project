package YA.Lesson20.controller;

import YA.Lesson20.domain.Periodical;
import YA.Lesson20.service.PeriodicalDTO;
import YA.Lesson20.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class PeriodicalsController {

    @Autowired
    private PeriodicalService periodicalService;

    @RequestMapping(value = "addPeriodical", method = RequestMethod.POST)
    public ModelAndView createPeriodical(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam MultipartFile image) throws IOException {

        periodicalService.save(PeriodicalDTO.createEntity(name, description, price, image ));

        return new ModelAndView("redirect:/home");

    }
    @RequestMapping(value ="/create-periodical", method = RequestMethod.GET)
    public String createPeriodical() {
        return "create-periodical";
    }


}
