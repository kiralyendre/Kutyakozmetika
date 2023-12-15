package com.project.Kutyakozmetika.repository;
import com.project.Kutyakozmetika.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsernameOrEmail(String username, String email);



}
