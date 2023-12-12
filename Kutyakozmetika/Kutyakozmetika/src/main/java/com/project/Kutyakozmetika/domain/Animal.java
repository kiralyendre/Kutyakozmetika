package com.project.Kutyakozmetika.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private Integer weight;
    @Column
    private String pictureOfTheAnimal;
    @Column
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_type")
    private AnimalType animalType;
}
