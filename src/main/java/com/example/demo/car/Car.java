package com.example.demo.car;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String vehicleId;
    @Column(unique=true)
    private String regNr;

    private boolean isParked;

    public Car(String vehicleId, String regNr, boolean isParked) {
        this.vehicleId = vehicleId;
        this.regNr = regNr;
        this.isParked = isParked;
    }

    //Using Lombok
}
