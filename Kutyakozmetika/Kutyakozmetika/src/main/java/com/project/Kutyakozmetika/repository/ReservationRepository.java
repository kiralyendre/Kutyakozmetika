package com.project.Kutyakozmetika.repository;
import com.project.Kutyakozmetika.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.userEntity.id = :id")
    List<Reservation> findAllByUserId(Long id);


}
