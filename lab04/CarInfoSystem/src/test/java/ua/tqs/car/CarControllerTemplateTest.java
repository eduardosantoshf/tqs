package ua.tqs.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CarInfoSystemApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "application-integrationtest.properties")
public class CarControllerTemplateTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    public void resetDB() {
        carRepository.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreateCar() throws IOException, Exception{
        Car car = new Car("BMW","Z4");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", car, Car.class);

        Car found = carRepository.findByModel(car.getModel());
        assertThat(found.getModel()).isEqualTo(car.getModel());
    }

    @Test
    public void givenCar_whenGetCar_theStatus200() throws Exception {
        Car car = new Car("BMW","Z4");
        carRepository.saveAndFlush(car);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+randomServerPort+"/api/car")
                .queryParam("model", "Z4");

        ResponseEntity<Car> response = restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getModel()).isEqualTo(car.getModel());
    }
}
