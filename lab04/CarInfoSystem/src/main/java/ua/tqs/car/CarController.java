package ua.tqs.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarManagerService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car c) {
        HttpStatus status = HttpStatus.CREATED;
        Car savedCar = carService.save(c);

        return new ResponseEntity<>(savedCar, status);
    }

    @GetMapping("/car")
    public Car getCarDetails(@RequestParam(name = "model") String model) {
        return carService.getCarDetails(model);
    }
}
