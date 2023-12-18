package com.project.Kutyakozmetika.controller;

import com.project.Kutyakozmetika.domain.ServiceType;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationCreateCommand;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationFormData;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationListItem;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationServiceTypeOption;
import com.project.Kutyakozmetika.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Void> saveReservation(HttpServletRequest request,
                                                @RequestBody ReservationCreateCommand command) {
        reservationService.saveReservation(request, command);
        log.info("new reservation created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationListItem>> getAllReservation() {
        log.info("Reservation list is requested");
        List<ReservationListItem> allReservation = reservationService.getAllReservation();
        return new ResponseEntity<>(allReservation, HttpStatus.OK);
    }

    @GetMapping("/myReservation")
    public ResponseEntity<List<ReservationListItem>> getMyReservation(HttpServletRequest request) {
        log.info("Reservation list is requested");
        return new ResponseEntity<>(reservationService.getMyReservation(request), HttpStatus.OK);
    }
    @GetMapping("/serviceTypes")
    public ResponseEntity<ReservationFormData> getReservationFormData() {
        ReservationFormData formData= new ReservationFormData(getServiceTypeOptions());
        log.info("Service type requested");
        return new ResponseEntity<>(formData, HttpStatus.OK);
    }

    private List<ReservationServiceTypeOption> getServiceTypeOptions() {
        List<ReservationServiceTypeOption> reservationServiceTypeOptions = new ArrayList<>();
        for (ServiceType st : ServiceType.values()) {
            reservationServiceTypeOptions.add(new ReservationServiceTypeOption(st));
        }
        return reservationServiceTypeOptions;
    }
}
