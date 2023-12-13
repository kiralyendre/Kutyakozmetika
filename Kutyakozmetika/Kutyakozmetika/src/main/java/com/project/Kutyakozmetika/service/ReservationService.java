package com.project.Kutyakozmetika.service;

import com.project.Kutyakozmetika.domain.Animal;
import com.project.Kutyakozmetika.domain.Reservation;
import com.project.Kutyakozmetika.domain.ServiceType;
import com.project.Kutyakozmetika.domain.User;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationCreateCommand;
import com.project.Kutyakozmetika.dto.reservationDto.ReservationListItem;
import com.project.Kutyakozmetika.repository.ReservationRepository;
import com.project.Kutyakozmetika.repository.UserRepository;
import com.project.Kutyakozmetika.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {
    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    public void saveReservation(HttpServletRequest request, ReservationCreateCommand command) {
        String username = getUsernameFromJwt(request);
        User user = userRepository.findByUsernameOrEmail(username, username);

        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        Reservation reservation = mapDtoToEntity(user, command);
        reservationRepository.save(reservation);
    }

    private Reservation mapDtoToEntity(User user, ReservationCreateCommand command) {
        Reservation reservation = new Reservation();
        reservation.setAnimalName(command.getAnimalName());
        reservation.setEmail(user.getEmail());
        reservation.setUsername(user.getUsername());
        reservation.setMobileNumber(user.getPhone());
        reservation.setReservationDateTime(LocalDateTime.now());
        reservation.setStartTime(LocalDateTime.parse(command.getStartTime()));
        reservation.setEndTime(LocalDateTime.parse(command.getStartTime()).plus(75, ChronoUnit.MINUTES));
        reservation.setUserEntity(user);
        reservation.setServiceTypes(command.getServiceTypes()
                .stream().map(ServiceType::valueOf).toList());
        return reservation;
    }

    private String getUsernameFromJwt(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String jwtToken = header.substring(7);
        return jwtUtil.extractUsername(jwtToken);

    }

    public List<ReservationListItem> getAllReservation() {
        List<Reservation> reservationList = reservationRepository.findAll();
        return reservationList.stream()
                .map(ReservationService::mapReservationListItemToEntity)
                .collect(Collectors.toList());
    }

    private static ReservationListItem mapReservationListItemToEntity(Reservation reservation) {
        ReservationListItem reservationListItem = new ReservationListItem();

        reservationListItem.setId(reservation.getId());
        reservationListItem.setAnimalName(reservation.getAnimalName());
        reservationListItem.setEmail(reservation.getEmail());
        reservationListItem.setUserName(reservation.getUsername());
        reservationListItem.setUserFirstName(reservation.getUserEntity().getFirstName());
        reservationListItem.setUserLastName(reservation.getUserEntity().getLastName());
        reservationListItem.setMobileNumber(reservation.getMobileNumber());
        reservationListItem.setReservationDateTime(String.valueOf(reservation.getReservationDateTime()));
        reservationListItem.setStartTime(String.valueOf(reservation.getStartTime()));
        reservationListItem.setEndTime(String.valueOf(reservation.getEndTime()));
        reservationListItem.setServiceTypes(reservation.getServiceTypes()
                .stream().map(serviceType -> serviceType.getDisplayName()).collect(Collectors.toList()));
        return reservationListItem;
    }

    public List<ReservationListItem> getMyReservation(HttpServletRequest request) {
        String username = getUsernameFromJwt(request);
        User user = userRepository.findByUsernameOrEmail(username, username);
        List<Reservation> result = reservationRepository.findAllByUserId(user.getId());
        return result.stream()
                .map(this::mapReservationToReservationListItemForUser).toList();

    }

    private ReservationListItem mapReservationToReservationListItemForUser(Reservation reservation) {
        ReservationListItem reservationListItem = new ReservationListItem();

        reservationListItem.setId(reservation.getId());
        reservationListItem.setAnimalName(reservation.getAnimalName());
        reservationListItem.setEmail(reservation.getEmail());
        reservationListItem.setUserName(reservation.getUsername());
        reservationListItem.setUserFirstName(reservation.getUserEntity().getFirstName());
        reservationListItem.setUserLastName(reservation.getUserEntity().getLastName());
        reservationListItem.setMobileNumber(reservation.getMobileNumber());
        reservationListItem.setReservationDateTime(String.valueOf(reservation.getReservationDateTime()));
        reservationListItem.setStartTime(String.valueOf(reservation.getStartTime()));
        reservationListItem.setEndTime(String.valueOf(reservation.getEndTime()));
        reservationListItem.setServiceTypes(reservation.getServiceTypes()
                .stream().map(serviceType -> serviceType.getDisplayName()).collect(Collectors.toList()));
        return reservationListItem;
    }

}
