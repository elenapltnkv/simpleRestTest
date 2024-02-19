package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class HomeWorkModelTest {
    @Test
    public void getRequestListOfUserTest() {
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(200);

    }

    @Test
    public void getRequestSingleUserTest() {
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/7")
                .then()
                .log().body()
                .statusCode(200);

    }

    @Test
    public void getRequestSingleUserNegativeTest() {
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/users/669")
                .then()
                .log().body()
                .statusCode(404);

    }

    @Test
    public void postNewUserTest() {
        String request = "{ \"name\": \"statham\", \"job\": \"actor\" }";
        given()
                .log().uri()
                .contentType(JSON)
                .body(request)
                .when()
                .put("https://reqres.in/api/users")
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void putUserUpdateTest() {
        String request = "{ \"name\": \"statham\", \"job\": \"driver\" }";
        given()
                .log().uri()
                .contentType(JSON)
                .body(request)
                .when()
                .put("https://reqres.in/api/users/669")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void deleteUserTest() {

        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .delete("https://reqres.in/api/users/669")
                .then()
                .log().body()
                .statusCode(204);
    }

    @Test
    public void postUserRegistrUserSuccsessTest() {
        String login = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        given()
                .log().uri()
                .contentType(JSON)
                .body(login)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .log().status()
                .body("id", is(4));
    }

    @Test
    public void postUserRegistrUserUnSuccsessTest() {
        String login = "{ \"email\": \"sydney@fife\"}";

        given()
                .log().uri()
                .contentType(JSON)
                .body(login)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
