package com.project.Kutyakozmetika.repository;

import com.project.Kutyakozmetika.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsernameOrEmail(String username, String email);

   User findUserByUsername(String username);

}
