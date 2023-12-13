package com.project.Kutyakozmetika.controller;

import com.project.Kutyakozmetika.dto.reservationDto.ReservationCreateCommand;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationListItem;
import com.project.Kutyakozmetika.repository.ReservationRepository;
import com.project.Kutyakozmetika.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {
  private ReservationService reservationService;
@PostMapping
    public ResponseEntity<Void> saveReservation(HttpServletRequest request,
                                                @RequestBody ReservationCreateCommand command){
    reservationService.saveReservation(request,command);
    log.info("new reservation created");
    return new ResponseEntity<>(HttpStatus.CREATED);
}
    @GetMapping
    public ResponseEntity<List<ReservationListItem>> getAllReservation() {
        log.info("Reservation list is requested");
        List<ReservationListItem> allReservation = reservationService.getAllReservation();
        return new ResponseEntity<>(allReservation, HttpStatus.OK);
    }
}
