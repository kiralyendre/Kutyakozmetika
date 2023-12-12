package com.project.Kutyakozmetika.repository;

import com.project.Kutyakozmetika.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.owner.id = :id")
    List<Animal> findAllByUserId(Long id);
}
