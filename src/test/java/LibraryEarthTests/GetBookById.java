package LibraryEarthTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookById {

    String accessToken;

    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = "http://library2.cybertekschool.com/rest/v1/";
        Response response = given().formParam("email","librarian21@library")
                .formParam("password","aZ849tSZ")
                .when().post("login");

        accessToken = response.path("token");
    }

    @Test
    public void test(){

        Response response = given().header("x-library-token",accessToken)
                .when().get("get_book_by_id/1");

        response.prettyPrint();
    }

}
