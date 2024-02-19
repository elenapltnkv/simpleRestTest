package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
//{"state":{"total":5,"used":0,"queued":0,"pending":0,"browsers":
//        {"chrome":{"119.0":{},"120.0":{}},"firefox":{"119.0":{},"120.0":{}},"opera":
//        {"104.0":{},"105.0":{}},"safari":{"15.0":{}}},"videos":null},"origin":"http://selenoid:4444","browsers":
//        {"chrome":0,"firefox":0,"opera":0,"safari":0},"sessions":{},"version":"1.10.11[2024-01-07_01:38:52PM]","errors":[]}

public class SimpleTest {

    @Test
    void firstSmokeRestTest() {
        given()
                .log().uri()
                .when()
                .get("http://192.168.1.10:8080/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("origin", is("http://selenoid:4444"));



    }
    @Test
    void firstSmokeRestBrowserTest() {
        given()
                .log().uri()
                .when()
                .get("http://192.168.1.10:8080/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("state.browsers.chrome", hasKey("120.0"));



    }
}
