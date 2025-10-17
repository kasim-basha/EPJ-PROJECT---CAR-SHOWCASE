package com.example.carshowcase.controller;

import com.example.carshowcase.model.Car;
import com.example.carshowcase.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // View all cars
    @GetMapping
    public String viewCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "viewCars";
    }

    // Show add car form
    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    // Save new car
    @PostMapping("/add")
    public String addCar(@ModelAttribute("car") Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    // Show edit car form
    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        return "editCar";
    }

    // Update car
    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable Long id, @ModelAttribute Car car) {
        car.setId(id);
        carService.saveCar(car);
        return "redirect:/cars";
    }

    // Delete car
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
