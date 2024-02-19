package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class LoginTest {
    //https://reqres.in/api/login
//"token": "QpwL5tke4Pnpja7X4"
    @Test
    void authLoginTest(){
        String data= "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .log().status()
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
