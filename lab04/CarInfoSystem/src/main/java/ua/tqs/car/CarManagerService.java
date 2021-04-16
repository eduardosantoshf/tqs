package ua.tqs.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarManagerService {
    @Autowired
    private CarRepository carRepository;

    public Car save(Car c) {
        return carRepository.save(c);
    }

    public Car getCarDetails(String model) {
        return carRepository.findByModel(model);
    }
}
