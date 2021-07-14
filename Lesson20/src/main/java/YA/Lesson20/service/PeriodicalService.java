package YA.Lesson20.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import YA.Lesson20.DAO.PeriodicalRepo;
import YA.Lesson20.domain.Periodical;

@Service
public class PeriodicalService {

    private Logger logger = LoggerFactory.getLogger(PeriodicalService.class);

    @Autowired
    private PeriodicalRepo periodicalRepository;

    public Periodical save(Periodical periodical) {
        logger.info("Create periodical item {} : " + periodical);
        return periodicalRepository.save(periodical);
    }

    public List<Periodical> getAllPeriodical() {
        logger.info("Get all periodicals items");
        return periodicalRepository.findAll();
    }

    public Periodical findById(Integer id) {
        logger.info("Get periodical item by id: " + id);
        return periodicalRepository.findById(id).get();
    }

}
