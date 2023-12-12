package com.project.Kutyakozmetika.controller;


import com.project.Kutyakozmetika.dto.animalDto.CreateAnimalCommand;

import com.project.Kutyakozmetika.service.AnimalService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/animal")
@AllArgsConstructor
public class AnimalController {

    private AnimalService animalService;


    @PostMapping("/register")
    public ResponseEntity<Void> saveAnimal(HttpServletRequest request,
                                           @RequestBody CreateAnimalCommand command) {
        animalService.saveAnimal(request, command);
        log.info("New animal created"+ command.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
