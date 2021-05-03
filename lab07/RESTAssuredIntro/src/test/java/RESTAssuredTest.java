import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RESTAssuredTest {

    @Test
    void checkEndpoint() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then().assertThat()
            .statusCode(200);
    }

    @Test
    void WhenGetSpecificTODO_ThenCheckTitle() {
        String expected = "et porro tempora";

        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos/4")
        .then().assertThat()
            .statusCode(200)
            .and().body("title", equalTo(expected))
            .and().body("id", equalTo(4));

    }

    @Test
    void whenCheckingAll_ThenCheck198And199() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then().assertThat()
            .statusCode(200)
            .body("id", hasItems(198, 199));
    }
}
