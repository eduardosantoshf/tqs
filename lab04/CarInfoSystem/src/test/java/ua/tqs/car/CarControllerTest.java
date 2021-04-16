package ua.tqs.car;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService carService;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void whenPostCars_thenReturnCars() throws Exception {
        Car car = new Car("Audi", "A4");

        
        when( carService.save(Mockito.any()) ).thenReturn(car);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Audi")))
                .andExpect(jsonPath("$.model", is("A4")));

        verify(carService, times(1)).save(Mockito.any());
    }


    @Test
    public void givenCar_whenGetCar_thenReturnJsonArray() throws Exception {
        Car car = new Car("Audi", "RS7");

        given( carService.getCarDetails("RS7")).willReturn(car);

        mvc.perform(get("/api/car").contentType(MediaType.APPLICATION_JSON).param("model", "RS7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maker", is("Audi")))
                .andExpect(jsonPath("$.model", is("RS7")));

        verify(carService, VerificationModeFactory.times(1)).getCarDetails("RS7");
        reset(carService);
    }
}