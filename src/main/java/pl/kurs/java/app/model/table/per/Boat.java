package pl.kurs.java.app.model.table.per;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "TABLE_PER_CLASS_BOAT")
public class Boat extends Vehicle {

    @NotNull
    private double length;

    public Boat(long id, String manufacturer, double length) {
        super(id, manufacturer);
        this.length = length;
    }

    public Boat() {
    }

    public double getLength() {
        return length;
    }
}

