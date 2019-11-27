package com.example.demo.car;

import com.example.demo.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CarController {

    @Autowired
    CarService carService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCar/{carId}")
    public Car getCar(@PathVariable long carId){
        return carService.getCar(carId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCars")
    public List<Car> getCars(){
        return carService.getCars();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/searchCar")
    public List<Car> searchCar(@RequestBody Search search){
        return carService.searchCar(search);
    }
}
