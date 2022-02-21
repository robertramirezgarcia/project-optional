package com.optional.projectoptional.service.impl;

import com.optional.projectoptional.model.Car;
import com.optional.projectoptional.service.CarService;

import java.util.Optional;

public class CarServiceImpl implements CarService {

    //Optional Empty
    public Optional<Car> getAllCarsEmpty(){
        return Optional.empty();
    }

    //Optional with a non-null value
    public Optional<Car> getAllCarsNotEmpty(){
        Car newCar = Car.builder().id("001").brand("Toyota").build();
        return Optional.of(newCar);
    }
}
