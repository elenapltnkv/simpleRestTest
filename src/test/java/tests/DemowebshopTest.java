package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemowebshopTest {

    @Test
    public void registrUserTest() {
        String data = "__RequestVerificationToken:jyXZOolXzz8nVX7WS_CuFBWXutjdgAI_AohSt-sOLpQVhVRVo8iLANCVN3RWgDhNBcA1ZeSNptGnLkM99bY62GZ86EuLL428Wpc_fcEZm341\n" +
                "Gender:F\n" +
                "FirstName:dfgdf1\n" +
                "LastName:hergyrg\n" +
                "Email:fadfac@gdff.cd\n" +
                "Password:123456\n" +
                "ConfirmPassword:123456\n" +
                "register-button:Register";
        given()
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif," +
                        "image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .contentType("application/x-www-form-urlencoded")
                .cookie("Nop.customer", "212e9797-b4af-4860-8328-da837cc62bbd; " +
                        "__RequestVerificationToken=qIWTRxBBpz1BlkGUy8TiJ7depfyKeRe9Ah7ZhjQXnGfdcrR8" +
                        "-juzrA1ifm_UoXhsSER1DFkwywEHjmpsOoscj4IuKUu1VpRT9kAXHoOSMlc1; " +
                        "NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72")
                .body(data)
                .when()
                .post("https://demowebshop.tricentis.com/register")
                .then()
                .log().all()
                .statusCode(302);

    }

    //addproducttocart

    @Test
    public void addProductToCartTest() {
        String data = "product_attribute_72_5_18=53&product_attribute_72_6_19=54" +
                "&product_attribute_72_3_20=57" +
                "&addtocart_72.EnteredQuantity=1";
        String cookie = "B418D134CB8EB2603AEC2FB0B36EFE9A5E1945ADAF88548DA7913157BFC67B0C33BA735FAC9B98329F9FD6" +
                "4B8083FFD4A49164DD981D4355AF5C18760B2450926079" +
                "187A90234D144BEFDDFE28886D5F38AF232E673009EE3D37C22E8B020193F5" +
                "465923B2F73788CC803D5C6B48237BFE9EA2927400482E1E4383C2A895BCC2B053AC2485D077735135A900D6D0FB01";
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookie)
                .body(data)
                .when()
                .post("https://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .log().body()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));

    }

    @Test
    public void getBooksPriceOverTest() {
        String cookie = "B418D134CB8EB2603AEC2FB0B36EFE9A5E1945ADAF88548DA7913157BFC67B0C33BA735FAC9B98329F9FD6" +
                "4B8083FFD4A49164DD981D4355AF5C18760B2450926079" +
                "187A90234D144BEFDDFE28886D5F38AF232E673009EE3D37C22E8B020193F5" +
                "465923B2F73788CC803D5C6B48237BFE9EA2927400482E1E4383C2A895BCC2B053AC2485D077735135A900D6D0FB01";
        given()
                .cookie("NOPCOMMERCE.AUTH", cookie)
                .when()
                .get("https://demowebshop.tricentis.com/books?price=50-")
                .then()
                .log().body()
                .statusCode(200);


    }
}
