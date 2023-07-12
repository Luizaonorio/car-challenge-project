package com.api.car.DTO;

import com.api.car.Entities.Car;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CarDTO {

    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name")
    @NotEmpty (message = "You forgot to fill in the name field")
    private String name;

    @Pattern(regexp = "^(Ford|Chevrolet|BMW|Volvo)$", message = "Incorrect brand name or outside partners")
    @NotEmpty (message = "You forgot to fill in the brand field")
    private String brand;
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid color")
    @NotEmpty (message = "You forgot to fill in the color field")
    private String color;

    @Pattern(regexp = "^\\d{4}(\\/\\d{4})?$", message = "Invalid date")
    @NotEmpty (message = "You forgot to fill in the fabrication year field")
    private String fabricationYear;

    public CarDTO() {
    }

    public CarDTO(Long idChassi, String name, String brand, String color, String fabricationYear) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public CarDTO(Car car) {
        this.name = car.getName();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.fabricationYear = car.getFabricationYear();
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
