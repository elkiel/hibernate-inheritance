package pl.kurs.java.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.java.app.service.CarService;
import pl.kurs.java.app.service.VehicleService;


@RestController
@RequestMapping("/vehicles/{STRATEGY}")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity getAllVehicles(@PathVariable("STRATEGY") String strategy) {
        return new ResponseEntity(vehicleService.getAllVehiclesWhereStrategy(strategy), HttpStatus.OK);
    }
}
