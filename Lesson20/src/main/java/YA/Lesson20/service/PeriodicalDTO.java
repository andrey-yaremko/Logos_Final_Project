package YA.Lesson20.service;

import YA.Lesson20.domain.Periodical;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class PeriodicalDTO {
    public static Periodical createEntity(String name, String description, Double price, MultipartFile image) throws IOException {

        Periodical periodical = new Periodical();
        periodical.setName(name);
        periodical.setDescription(description);
        periodical.setPrice(price);
        periodical.setEncoded_image(Base64.getEncoder().encodeToString(image.getBytes()));

        return periodical;

    }
}
