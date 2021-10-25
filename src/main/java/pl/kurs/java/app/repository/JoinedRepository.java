package pl.kurs.java.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kurs.java.app.model.joined.table.Vehicle;
import pl.kurs.java.app.model.joined.table.Boat;
import pl.kurs.java.app.model.joined.table.Car;

import javax.persistence.InheritanceType;
import java.util.List;

@Repository
public interface JoinedRepository extends InheritanceTypeRepository<Vehicle>{

    @Query("select distinct c from JOINED_CAR as c ")
    public List<Car> getAllCars();

    @Query("select distinct b from JOINED_BOAT as b ")
    public List<Boat> getAllBoats();

    default Class<?> getClassOfCar() {
        return Car.class;
    }

    default Class<?> getClassOfBoat() {
        return Boat.class;
    }

    default InheritanceType getInheritanceType() {
        return InheritanceType.JOINED;
    }
}
