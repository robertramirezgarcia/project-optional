package com.optional.projectoptional.service;

import com.optional.projectoptional.model.Car;

import java.util.Optional;

public interface CarService {

    Optional<Car> getAllCarsEmpty();

    Optional<Car> getAllCarsNotEmpty();
}