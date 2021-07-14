package YA.Lesson20.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity = YA.Lesson20.domain.User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(targetEntity = Periodical.class)
    @JoinColumn(name = "periodical_id", referencedColumnName = "id")
    private Periodical periodical;
    @Column
    private Date purchaseDate;

    public Bucket() {
        super();
    }

    public Bucket(Integer id) {
        this.id = id;
    }

    public Bucket(User user, Periodical periodical, Date purchaseDate) {
        super();
        this.user = user;
        this.periodical = periodical;
        this.purchaseDate = purchaseDate;
    }


}