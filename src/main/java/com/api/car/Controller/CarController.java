package com.api.car.Controller;

import com.api.car.DTO.CarDTO;
import com.api.car.Entities.Car;
import com.api.car.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/get/{idChassi}")
    public Car finById(@PathVariable Long idChassi) {
        return carService.findById(idChassi);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<String> createCar(@RequestBody @Valid CarDTO carDTO, BindingResult bindingResult) {
        return carService.createCar(carDTO, bindingResult, carService);
    }
}
