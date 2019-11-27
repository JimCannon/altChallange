package com.example.demo.car;

import com.example.demo.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CarService{

    @Autowired
    private EntityManager entityManager;
    @Autowired
    CarRepository carRepository;

    public Car getCar(long carId){
        return carRepository.findById(carId);
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public List<Car> searchCar(@RequestBody Search search){
        StringBuilder sb = new StringBuilder();
        sb.append("Select * from Car where id > 0");

        if(search.getIsParked() != null){
            sb.append(" and parked = \'" + search.getIsParked() + "\'");
        }
        return entityManager.createNativeQuery(sb.toString(), Car.class).getResultList();
    }

}