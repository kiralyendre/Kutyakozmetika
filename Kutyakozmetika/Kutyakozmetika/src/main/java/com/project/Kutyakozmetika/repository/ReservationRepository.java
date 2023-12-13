package com.project.Kutyakozmetika.repository;

import com.project.Kutyakozmetika.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
