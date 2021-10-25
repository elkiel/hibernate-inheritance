package pl.kurs.java.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.app.repository.InheritanceTypeRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.InheritanceType;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final List<InheritanceTypeRepository> repositories;

    public List<?> getAllVehiclesWhereStrategy(String strategy) {
        InheritanceType type = InheritanceType.valueOf(strategy);

        return repositories.stream()
                .filter(n -> n.getInheritanceType() == type)
                .findFirst().orElseThrow(EntityNotFoundException::new)
                .findAll();
    }

}
