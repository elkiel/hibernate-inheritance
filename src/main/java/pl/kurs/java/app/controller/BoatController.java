package pl.kurs.java.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import pl.kurs.java.app.model.command.CreateBoatCommand;
import pl.kurs.java.app.service.BoatService;

import javax.validation.Valid;

@Getter
@Setter
@RestController
@RequestMapping("/boats")
@RequiredArgsConstructor
public class BoatController {

    private final BoatService boatService;

    @GetMapping("/{STRATEGY}")
    public ResponseEntity getAllCars(@PathVariable("STRATEGY") String strategy) {
        return new ResponseEntity(boatService.getAllBoatsWhereStrategy(strategy), HttpStatus.OK);
    }

    @PostMapping("/{STRATEGY}")
    public ResponseEntity addNewBoat(@PathVariable("STRATEGY") String strategy, @RequestBody @Valid CreateBoatCommand boat) {
        return new ResponseEntity(boatService.addBoatInStrategy(strategy,boat),HttpStatus.OK);
    }
}
