package pl.kurs.java.app.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.kurs.java.app.model.command.CreateBoatCommand;
import pl.kurs.java.app.repository.InheritanceTypeRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.InheritanceType;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoatService {

    private final List<InheritanceTypeRepository> repositories;

    private final ModelMapper modelMapper;


    public Object addBoatInStrategy(String strategy, CreateBoatCommand boat) {
        return findRepositoryWithStrategy(strategy).saveAndFlush(modelMapper.map(boat, getClassOfBoat(strategy)));
    }

    public List<?> getAllBoatsWhereStrategy(String strategy) {
        return getAllObjectsWhereStrategy(strategy).stream()
                .filter(n -> n.getClass().equals(getClassOfBoat(strategy)))
                .collect(Collectors.toList());

    }

    public List<?> getAllObjectsWhereStrategy(String strategy) {
        return findRepositoryWithStrategy(strategy).findAll();
    }

    public Class<?> getClassOfBoat(String strategy) {
        return findRepositoryWithStrategy(strategy).getClassOfBoat();
    }

    public InheritanceTypeRepository findRepositoryWithStrategy(String strategy) {
        InheritanceType type = InheritanceType.valueOf(strategy);

        return repositories.stream()
                .filter(n -> n.getInheritanceType() == type)
                .findFirst().orElseThrow(EntityNotFoundException::new);
    }
}
