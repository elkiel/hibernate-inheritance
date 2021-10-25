package pl.kurs.java.app.model.table.per;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;

@Entity(name = "VEHICLE_TABLE_PER_CLASS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
