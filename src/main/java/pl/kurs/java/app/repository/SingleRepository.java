package pl.kurs.java.app.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import pl.kurs.java.app.model.single.table.Boat;
import pl.kurs.java.app.model.single.table.Car;
import pl.kurs.java.app.model.single.table.Vehicle;

import javax.persistence.InheritanceType;
import java.util.List;

@Repository
public interface SingleRepository extends InheritanceTypeRepository<Vehicle> {

    @Query("select distinct c from SINGLE_TABLE_CAR as c ")
    public List<Car> getAllCars();

    @Query("select distinct b from SINGLE_TABLE_BOAT as b ")
    public List<Boat> getAllBoats();

    default Class<?> getClassOfCar() {
        return Car.class;
    }

    default Class<?> getClassOfBoat() {
        return Boat.class;
    }

    default InheritanceType getInheritanceType() {
        return InheritanceType.SINGLE_TABLE;
    }
}