package pl.kurs.java.app.model.joined.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "JOINED_CAR")
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
