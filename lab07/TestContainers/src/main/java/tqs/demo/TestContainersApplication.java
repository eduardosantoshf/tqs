package tqs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootApplication
public class TestContainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestContainersApplication.class, args);
    }

}
