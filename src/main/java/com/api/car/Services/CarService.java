package com.api.car.Services;

import com.api.car.DTO.CarDTO;
import com.api.car.Entities.Car;
import com.api.car.Repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class UserNotFoundException extends RuntimeException{

    }

    public Car findById(Long idChassi) {
        Optional<Car> optionalCar = carRepository.findById(idChassi);
        return optionalCar.orElseThrow(UserNotFoundException::new);
    }

    private Car createCarModel(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setName(carDTO.getName());
        car.setFabricationYear(carDTO.getFabricationYear());

        return car;
    }

    @Transactional
    public String create(CarDTO carDTO) {
        carRepository.save(createCarModel(carDTO));
        return "User created successfully";
    }

    public ResponseEntity<String> createCar(CarDTO carDTO, BindingResult bindingResult, CarService carService) {
        if (!bindingResult.hasErrors()){
            return ResponseEntity.ok(carService.create(carDTO));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bindingResult.getFieldError().getDefaultMessage());
        }
    }

    public String deleteCar(Long idChassi) {
        Optional<Car> optionalCar = carRepository.findById(idChassi);
        if (optionalCar.isPresent()) {
            carRepository.deleteById(idChassi);
            return "Car deleted";
        } else {
            throw new UserNotFoundException();
        }
    }
}
