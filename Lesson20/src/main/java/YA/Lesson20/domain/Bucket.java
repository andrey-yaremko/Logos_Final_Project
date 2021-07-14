package YA.Lesson20.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity = YA.Lesson20.domain.User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Integer userId;
    @ManyToOne(targetEntity = YA.Lesson20.domain.User.class)
    @JoinColumn(name = "product_id", referencedColumnName ="id")
    private Integer productId;
    @Column
    private Date purchaseDate;

    public Bucket() {
        super();
    }

    public Bucket(Integer id, Integer userId, Integer productId, Date purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer userId, Integer productId, Date purchaseDate) {
        super();
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(id, bucket.id) && Objects.equals(userId, bucket.userId) && Objects.equals(productId, bucket.productId) && Objects.equals(purchaseDate, bucket.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, purchaseDate);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
