package in.bigbasket.readPrice.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prodId;
    private String name;
    private String quantity;
    private Double price;
    @CreationTimestamp
    private Timestamp timestamp;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return  Objects.equals(getProdId(), product.getProdId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getQuantity(), product.getQuantity()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getTimestamp(), product.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProdId(), getName(), getQuantity(), getPrice(), getTimestamp());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", prodId='" + prodId + '\'' +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
