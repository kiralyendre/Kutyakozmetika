package com.project.Kutyakozmetika.service;

import com.project.Kutyakozmetika.domain.Animal;
import com.project.Kutyakozmetika.domain.AnimalType;
import com.project.Kutyakozmetika.domain.User;
import com.project.Kutyakozmetika.dto.animalDto.AnimalListItem;
import com.project.Kutyakozmetika.dto.animalDto.CreateAnimalCommand;
import com.project.Kutyakozmetika.repository.AnimalRepository;
import com.project.Kutyakozmetika.repository.UserRepository;
import com.project.Kutyakozmetika.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@Transactional
@AllArgsConstructor
public class AnimalService {
    private UserRepository userRepository;
    private JwtUtil jwtUtil;
    private AnimalRepository animalRepository;


    public void saveAnimal(HttpServletRequest request, CreateAnimalCommand command) {
        String username = getUsernameFromJwt(request);
        User user = userRepository.findByUsernameOrEmail(username,username);

        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        Animal animal = mapDtoToEntity(user, command);
        animalRepository.save(animal);
    }

    private Animal mapDtoToEntity(User user, CreateAnimalCommand command) {
        Animal animal = new Animal();
        animal.setName(command.getName());
        animal.setAge(command.getAge());
        animal.setWeight(command.getWeight());
        animal.setPictureOfTheAnimal(command.getPictureOfTheAnimal());
        animal.setBreed(command.getBreed());
        animal.setAnimalType(AnimalType.valueOf(command.getAnimalType()));
        animal.setOwner(user);
        return animal;
    }

    private String getUsernameFromJwt(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String jwtToken = header.substring(7);
        return jwtUtil.extractUsername(jwtToken);
    }
}
