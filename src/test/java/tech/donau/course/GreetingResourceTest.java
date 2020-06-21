package tech.donau.course;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;
import tech.donau.course.config.GreetingConfig;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("_Hello test!!!Your country is Testland(2)."));
    }

    @Test
    public void testHelloWithNameEndpoint() {
        final String name = UUID.randomUUID().toString();
        given()
                .when().get("/hello/" + name)
                .then()
                .statusCode(200)
                .body(is(String.format("Hello %s, your ID is %s.", name, "1234")));
    }
}