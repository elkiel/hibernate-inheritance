package pl.kurs.java.app.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import pl.kurs.java.app.model.command.CreateBoatCommand;
import pl.kurs.java.app.model.command.CreateCarCommand;
import pl.kurs.java.app.model.single.table.Car;
import pl.kurs.java.app.repository.InheritanceTypeRepository;
import pl.kurs.java.app.repository.SingleRepository;
import pl.kurs.java.app.repository.TablePerClassRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.InheritanceType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final List<InheritanceTypeRepository> repositories;

    private final ModelMapper modelMapper;


    public Object addCarInStrategy(String strategy, CreateCarCommand car) {
        return findRepositoryWithStrategy(strategy).saveAndFlush(modelMapper.map(car, getClassOfCar(strategy)));
    }

    public List<?> getAllObjectsWhereStrategy(String strategy) {
        return findRepositoryWithStrategy(strategy).findAll();
    }

    public List<?> getAllCarsWhereStrategy(String strategy) {
        return getAllObjectsWhereStrategy(strategy).stream()
                .filter(n -> n.getClass().equals(getClassOfCar(strategy)))
                .collect(Collectors.toList());

    }

    public Class<?> getClassOfCar(String strategy) {
        return findRepositoryWithStrategy(strategy).getClassOfCar();
    }

    public InheritanceTypeRepository findRepositoryWithStrategy(String strategy) {
        InheritanceType type = InheritanceType.valueOf(strategy);

        return repositories.stream()
                .filter(n -> n.getInheritanceType() == type)
                .findFirst().orElseThrow(EntityNotFoundException::new);
    }
}
