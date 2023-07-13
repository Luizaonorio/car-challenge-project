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

    public CarDTO createCarDTOModel(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setName(car.getName());
        carDTO.setFabricationYear(car.getFabricationYear());
        return carDTO;
    }

    public CarDTO findById(Long idChassi) {
        Optional<Car> carOptional = carRepository.findById(idChassi);
        CarDTO carDTO = carOptional.map(this::createCarDTOModel).orElseThrow(UserNotFoundException::new);
        return carDTO;
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
    public ResponseEntity<String> createCar(CarDTO carDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldError().getDefaultMessage());
        }
        else {
            carRepository.save(createCarModel(carDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    " ---------------- \n"
                            + " Car was created! \n"
                            + " ---------------- \n \n"
                            + " Name: " + carDTO.getName()
                            + "\n Brand: " + carDTO.getBrand()
                            + "\n Color: " + carDTO.getColor()
                            + "\n Fabrication Year: " + carDTO.getFabricationYear());
        }
    }
}
