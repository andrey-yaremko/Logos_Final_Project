package YA.Lesson20.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Periodical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;

    @Lob
    private String encoded_image;

    public Periodical() {
        super();
    }

    public Periodical(String name, String description, Double price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
