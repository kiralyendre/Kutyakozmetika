package com.project.Kutyakozmetika.dto.reservationDto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ReservationListItem {
    private Long id;
    private String animalName;
    private String email;
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String mobileNumber;
    private String reservationDateTime;
    private String startTime;
    private String endTime;
    private List<String> serviceTypes;
}
