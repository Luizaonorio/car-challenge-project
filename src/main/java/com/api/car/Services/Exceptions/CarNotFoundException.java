package com.api.car.Services.Exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException (Object idChassi) {
        super("Car not found, id: " + idChassi);
    }
}
