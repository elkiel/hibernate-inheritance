package pl.kurs.java.app.model.single.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "SINGLE_TABLE_BOAT")
@DiscriminatorValue("BOAT")
public class Boat extends Vehicle{

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
