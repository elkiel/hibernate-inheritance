package pl.kurs.java.app.model.single.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "SINGLE_TABLE_CAR")
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    @NotNull
    private int seats;

    public Car(long id, String manufacturer, int seats) {
        super(id, manufacturer);
        this.seats = seats;
    }

    public Car() {
    }
}
