package com.api.car.DTO;

import com.api.car.Entities.Car;

public class CarDTOResponse {

    private Long idChassi;

    private String name;

    private String brand;

    private String color;

    private String fabricationYear;


    public CarDTOResponse() {
    }

    public CarDTOResponse(Long idChassi, String name, String brand, String color, String fabricationYear) {
        this.idChassi= idChassi;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public CarDTOResponse(Car car) {
        this.idChassi = car.getIdChassi();
        this.name = car.getName();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.fabricationYear = car.getFabricationYear();
    }

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long idChassi) {
        this.idChassi = idChassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}
