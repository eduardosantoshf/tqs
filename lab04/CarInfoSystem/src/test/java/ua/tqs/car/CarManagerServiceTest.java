package ua.tqs.car;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarManagerServiceTest {
    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carService;

    @BeforeEach
    public void setUp() {
        Car car = new Car("Audi", "RS7");

        Mockito.when(carRepository.findByModel(car.getModel())).thenReturn(car);
        Mockito.when(carRepository.findByModel("wrong")).thenReturn(null);
    }

    @Test
    public void whenValidModel_thenCarShouldBeFound() {
        String model = "RS7";
        Car foundCar = carService.getCarDetails(model);

        assertThat(foundCar.getModel()).isEqualTo(model);
    }

    @Test
    public void whenInvalidModel_thenCarShouldNotBeFound() {
        Car carFromDB = carService.getCarDetails("wrong");
        assertThat(carFromDB).isNull();

        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByModel("wrong");
        Mockito.reset(carRepository);
    }
}
