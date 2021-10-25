package pl.kurs.java.app.model.joined.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;

@Entity(name = "JOINED_VEHICLE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String manufacturer;

    public Vehicle(long id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public Vehicle() {

    }

    public long getId() {
        return id;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
