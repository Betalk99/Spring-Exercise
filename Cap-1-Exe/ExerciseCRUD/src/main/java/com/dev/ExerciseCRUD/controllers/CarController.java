package com.dev.ExerciseCRUD.controllers;

import com.dev.ExerciseCRUD.entities.Car;
import com.dev.ExerciseCRUD.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping
    public Car createCar(@RequestBody Car carReq){
        Car car = carRepository.saveAndFlush(carReq);
        return car;
    }

    @GetMapping
    public List<Car> listCar(){
        List<Car> carList = carRepository.findAll();
        return carList;
    }

    @GetMapping(path = "/{id}")
    public Car getCarId(
            @PathVariable Long id){
        if(carRepository.existsById(id)){
            Car oneCar = carRepository.getById(id);
            return oneCar;
        }else {
            Car emptyCar = new Car();
            return emptyCar;
        }

    }

    @PutMapping(path = "/{id}")
    public Car upgTypeCarWithID(@PathVariable Long id, @RequestParam String type){
        if(carRepository.existsById(id)){
            Car typeCar = carRepository.getById(id);
            typeCar.setType(type);
            carRepository.saveAndFlush(typeCar);
            return typeCar;
        }else {
            Car emptyCar = new Car();
            return emptyCar;
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteID(@PathVariable Long id){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping
    public void deleteAll(){
        carRepository.deleteAll();
    }

}
