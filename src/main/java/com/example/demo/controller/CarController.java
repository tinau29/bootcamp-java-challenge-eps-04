package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping({"/cars","cars"})
    public List<Car> indexAction(){
        return carRepository.findAll();
    }

    @PostMapping({"/cars", "/cars/"})
    public ResponseEntity<Map<String, Object>> createCar(@RequestBody Car car) {
        Map<String, Object> res = new HashMap<>();

        try{
            carRepository.save(car);
        }catch(Exception e) {
            res.put("is_success", false);
            res.put("message", "error "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        res.put("is_success", true);
        res.put("message", "success");
        res.put("car", car);
        return ResponseEntity.ok(res);
    }

    @PutMapping({"/cars/{id}", "/cars/{id}"})
    public ResponseEntity<Map<String, Object>> updateCar(@PathVariable("id") Car oldCar, @RequestBody Car newCar){
        Map<String, Object> res = new HashMap<>();

        try{
            oldCar.setBranch(newCar.getBranch());
            oldCar.setSeries(newCar.getSeries());
            oldCar.setTopSpeedKmph(newCar.getTopSpeedKmph());
            oldCar.setCountry(newCar.getCountry());
            carRepository.save(newCar);
        }catch(Exception e) {
            res.put("is_success", false);
            res.put("message", "error "+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }

        res.put("is_success", true);
        res.put("message", "success");
        res.put("car", oldCar);
        return ResponseEntity.ok(res);
    }
}
