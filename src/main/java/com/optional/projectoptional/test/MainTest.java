package com.optional.projectoptional.test;

import com.optional.projectoptional.exception.ResourceNotFoundException;
import com.optional.projectoptional.model.Car;
import com.optional.projectoptional.service.CarService;
import com.optional.projectoptional.service.impl.CarServiceImpl;

public class MainTest {

    public static void main(String[] args){

        CarServiceImpl carService = new CarServiceImpl();

        //Use ifPresent
        System.out.println("**Results use of ifPresent ");
        carService.getAllCarsEmpty().ifPresent(car -> {
            System.out.println("Car's brand= " + car.getBrand());
        });

        carService.getAllCarsNotEmpty().ifPresent(car -> {
            System.out.println("Car's brand= " + car.getBrand());
        });

        //Use orElse
        System.out.println("**Results use of orElse ");
        System.out.println(carService.getAllCarsEmpty().orElse(new Car("0002", "BMW")));
        System.out.println(carService.getAllCarsNotEmpty().orElse(new Car("0003", "Mercedes Benz")));

        //Use orElse
        System.out.println("**Results use of orElseThrow ");
        try{
            carService.getAllCarsEmpty().orElseThrow(
                    () -> ResourceNotFoundException.builder()
                            .message("Car not found")
                            .build()
            );
        } catch(Exception e){
            System.out.println(e);
        }

        //Use filter
        System.out.println("**Results use filter ");
        carService.getAllCarsNotEmpty()
                .filter(car -> car.getBrand().equalsIgnoreCase("BMW"))
                .ifPresent(car -> {
                    System.out.println("Car's brand (filter) = " + car.getBrand());
                });

        //Use map
        System.out.println("**Results use map ");
        carService.getAllCarsNotEmpty()
                .map(Car::getBrand)
                .filter(brand -> brand.equalsIgnoreCase("Toyota"))
                .ifPresent(brand -> { System.out.println("Brand filter is: " + brand); });

    }
}
