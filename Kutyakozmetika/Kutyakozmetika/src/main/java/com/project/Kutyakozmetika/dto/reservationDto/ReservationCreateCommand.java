package com.project.Kutyakozmetika.dto.reservationDto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class ReservationCreateCommand {
    private Long userId;
    private String animalName;
    private String email;
    private String username;
    private String mobileNumber;
    private LocalDateTime reservationDateTime;
    private String startTime;
    private String endTime;

    private List<String> serviceTypes;

}
