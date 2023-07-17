package com.api.car.Services;

import com.api.car.DTO.CarDTORequest;
import com.api.car.DTO.CarDTOResponse;
import com.api.car.Entities.Car;
import com.api.car.Repository.CarRepository;
import com.api.car.Services.Exceptions.CarNotFoundException;
import com.api.car.Services.Exceptions.IllegalBrandException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDTOResponse createCarDTOModel(Car car) {
        CarDTOResponse carDTOResponse = new CarDTOResponse();
        carDTOResponse.setIdChassi(car.getIdChassi());
        carDTOResponse.setBrand(car.getBrand());
        carDTOResponse.setColor(car.getColor());
        carDTOResponse.setName(car.getName());
        carDTOResponse.setFabricationYear(car.getFabricationYear());
        return carDTOResponse;
    }

    public CarDTOResponse findById(Long idChassi) {
        Optional<Car> carOptional = carRepository.findById(idChassi);
        CarDTOResponse carDTOResponse = carOptional.map(this::createCarDTOModel).orElseThrow(() -> new CarNotFoundException(idChassi));
        return carDTOResponse;
    }

    private Car createCarModel(CarDTORequest carDTORequest) {
        validateBrand(carDTORequest.getBrand());
        Car car = new Car();
        car.getIdChassi();
        car.setBrand(carDTORequest.getBrand());
        car.setColor(carDTORequest.getColor());
        car.setName(carDTORequest.getName());
        car.setFabricationYear(carDTORequest.getFabricationYear());

        return car;
    }

    @Transactional
    public ResponseEntity<CarDTOResponse> createCar(CarDTORequest carDTORequest) {
            Car car = carRepository.save(createCarModel(carDTORequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(new CarDTOResponse(car));
    }

    private void validateBrand(String brand) {
        final String[] disponibleBrand = {"BMW", "Volvo", "Chevrolet", "Ford"};
        if (!Arrays.asList(disponibleBrand).contains(brand)) {
            throw new IllegalBrandException(brand);
        }
    }
}