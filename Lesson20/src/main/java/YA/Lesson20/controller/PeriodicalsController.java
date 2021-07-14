package YA.Lesson20.controller;

import YA.Lesson20.domain.Periodical;
import YA.Lesson20.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PeriodicalsController {

    @Autowired
    private PeriodicalService periodicalService;

    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    public String createPeriodical(@Valid @ModelAttribute("periodical") Periodical periodical, BindingResult bindingResult) {

        periodicalService.save(periodical);

        return "redirect:home";
    }

}
