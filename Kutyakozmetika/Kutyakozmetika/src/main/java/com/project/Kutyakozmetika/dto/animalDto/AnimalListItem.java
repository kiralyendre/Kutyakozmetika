package com.project.Kutyakozmetika.dto.animalDto;

import lombok.Data;

@Data
public class AnimalListItem {
    private Long id;
    private String name;
    private Integer age;
    private Integer weight;
    private String pictureOfTheAnimal;
    private String breed;
    private Long ownerId;
    private String animalType;
}
