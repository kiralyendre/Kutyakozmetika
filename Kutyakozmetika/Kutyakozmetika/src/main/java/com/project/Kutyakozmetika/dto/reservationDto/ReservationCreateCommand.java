package com.project.Kutyakozmetika.dto.reservationDto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class ReservationCreateCommand {

    private String animalName;
    private String startTime;
    private List<String> serviceTypes;

}
