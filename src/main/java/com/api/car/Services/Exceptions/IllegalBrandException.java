package com.api.car.Services.Exceptions;

public class IllegalBrandException extends RuntimeException {
    public IllegalBrandException (Object brand) {
        super("Brand not exists: " + brand);
    }
}
