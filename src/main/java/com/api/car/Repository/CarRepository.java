package com.api.car.Repository;

import com.api.car.DTO.CarDTO;
import com.api.car.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
