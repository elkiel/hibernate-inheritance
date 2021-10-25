package pl.kurs.java.app.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.java.app.model.command.CreateCarCommand;
import pl.kurs.java.app.service.CarService;

import javax.validation.Valid;

@Getter
@Setter
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{STRATEGY}")
    public ResponseEntity getAllCars(@PathVariable("STRATEGY") String strategy) {
        return new ResponseEntity(carService.getAllCarsWhereStrategy(strategy), HttpStatus.OK);
    }
    @PostMapping("/{STRATEGY}")
    public ResponseEntity addNewCar(@PathVariable("STRATEGY") String strategy, @RequestBody @Valid CreateCarCommand car){
        return new ResponseEntity(carService.addCarInStrategy(strategy,car),HttpStatus.OK);
    }
}
