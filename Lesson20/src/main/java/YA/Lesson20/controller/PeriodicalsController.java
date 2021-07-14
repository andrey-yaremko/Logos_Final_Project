package YA.Lesson20.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import YA.Lesson20.service.PeriodicalDTO;
import YA.Lesson20.service.PeriodicalService;

@Controller
public class PeriodicalsController {

    @Autowired
    PeriodicalService periodicalsService;

    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    public ModelAndView createPeriodical(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price) throws IOException {

        periodicalsService.save(PeriodicalDTO.createEntity(image, name, description, price));
        return new ModelAndView("redirect:/home");
    }
}
