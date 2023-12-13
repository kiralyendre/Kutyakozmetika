package com.project.Kutyakozmetika.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userEntity;
    @Column
    private String animalName;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String mobileNumber;
    @Column
    private LocalDateTime reservationDateTime;

    @Column

    private LocalDateTime startTime;
    @Column

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ServiceType.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "service_type")
    @Column(name = "service_type")

    private List<ServiceType> serviceTypes = new ArrayList<>();

}
