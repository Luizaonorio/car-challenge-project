package com.api.car.Controller;

import com.api.car.DTO.CarDTORequest;
import com.api.car.DTO.CarDTOResponse;
import com.api.car.Services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/get/{idChassi}")
    public CarDTOResponse finById(@PathVariable Long idChassi) {
        return carService.findById(idChassi);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<CarDTOResponse> createCar(@Valid @RequestBody CarDTORequest carDTORequest) {
        return carService.createCar(carDTORequest);
    }
}
