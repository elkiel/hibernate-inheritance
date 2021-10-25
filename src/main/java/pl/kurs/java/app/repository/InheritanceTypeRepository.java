package pl.kurs.java.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.InheritanceType;

@NoRepositoryBean
public interface InheritanceTypeRepository<T> extends JpaRepository<T,Long> {
    InheritanceType getInheritanceType();

    Class<?> getClassOfCar();

    Class<?> getClassOfBoat();
}
