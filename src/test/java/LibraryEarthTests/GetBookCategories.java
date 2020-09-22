package LibraryEarthTests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import utilities.ConfigurationReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.testng.Assert.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.given;

    public class GetBookCategories {

        String accessToken;

        @BeforeClass
        public void beforeClass(){
            RestAssured.baseURI = "http://library2.cybertekschool.com/rest/v1";
            Response response = given().formParam("email","librarian21@library")
                    .formParam("password","aZ849tSZ")
                    .when().post("login");

            accessToken = response.path("token");
        }

        @Test
        public void test(){

            Response response = given().header("x-library-token",accessToken)
                    .when().get("get_book_categories");

            response.prettyPrint();
        }

    }
