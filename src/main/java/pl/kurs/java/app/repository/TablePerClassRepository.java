package pl.kurs.java.app.repository;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kurs.java.app.model.table.per.Boat;
import pl.kurs.java.app.model.table.per.Car;
import pl.kurs.java.app.model.table.per.Vehicle;

import javax.persistence.InheritanceType;
import java.util.List;


@Repository
public interface TablePerClassRepository extends InheritanceTypeRepository<Vehicle> {

    @Query("select distinct c from TABLE_PER_CLASS_CAR as c ")
    public List<Car> getAllCars();

    @Query("select distinct b from TABLE_PER_CLASS_BOAT as b ")
    public List<Boat> getAllBoats();

    default Class<?> getClassOfCar() {
        return Car.class;
    }

    default Class<?> getClassOfBoat() {
        return Boat.class;
    }

    default InheritanceType getInheritanceType() {
        return InheritanceType.TABLE_PER_CLASS;
    }

}
