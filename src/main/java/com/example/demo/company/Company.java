package com.example.demo.company;

import com.example.demo.car.Car;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Car> carList;

    public Company(String companyName, String address, List<Car> carList){
        this.companyName = companyName;
        this.address = address;
        this.carList = carList;
    }

    //Using Lombok for Get&Setters
}
