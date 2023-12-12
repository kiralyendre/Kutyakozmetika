package com.project.Kutyakozmetika.dto.animalDto;


import lombok.Data;

@Data

public class CreateAnimalCommand {
    private Long ownerId;
    private String name;
    private Integer age;
    private Integer weight;
    private String pictureOfTheAnimal;
    private String breed;
    private String animalType;
}
