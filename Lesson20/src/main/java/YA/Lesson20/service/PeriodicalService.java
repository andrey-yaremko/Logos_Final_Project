package YA.Lesson20.service;

import YA.Lesson20.DAO.PeriodicalRepo;
import YA.Lesson20.domain.Periodical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodicalService {

    @Autowired
    private PeriodicalRepo periodicalRepo;

    public Periodical save(Periodical periodical) {
        return periodicalRepo.save(periodical);
    }


    public List<Periodical> getAllPeriodical(){
        return periodicalRepo.findAll();
    }

    public Periodical findById(Integer id) {
        return periodicalRepo.findById(id).get();
    }

}
