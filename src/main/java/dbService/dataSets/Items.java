package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "itemsMyShop")
public class Items implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8119184405056963442L;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "quantity", unique = true, updatable = false)
    private String quantity;

    @Column(name = "description", unique = false, updatable = true)
    private String description;

    @Column(name = "unit", unique = false, updatable = true)
    private int unit;

    @Column(name = "price", unique = false, updatable = true)
    private double price;

    @Column(name = "measurement", unique = false, updatable = true)
    private String measurement;

    public Items(long id, String quantity, String description, int unit, double price, String measurement) {
        this.setId(id);
        this.quantity = quantity;
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.measurement = measurement;
    }

    public Items(String quantity, String description, int unit, double price, String measurement) {
        this.setId(-1);
        this.quantity = quantity;
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.measurement = measurement;
    }

    public Items() {
    }

    @Override
    public String toString() {
        return "Items{" +
                "  id=" + id +
                ", quanity='" + quantity + '\'' +
                ", unit=" + unit +
                ", measurement='" + measurement + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuanity() {
        return quantity;
    }

    public void setQuanity(String quantity) {
        this.quantity = quantity;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}