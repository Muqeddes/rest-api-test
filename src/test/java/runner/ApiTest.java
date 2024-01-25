package runner;

import apiutilities.AppConfig;
import apiutilities.PayloadUtilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;

public class ApiTest {

    AppConfig appConfig = new AppConfig();
    PayloadUtilities payloadUtilities = new PayloadUtilities();

    @Test(description = "Post: Create user")
    public void createUser() {
        RestAssured.baseURI = appConfig.readFromConfig("baseUrl");
        Response response = RestAssured.given().headers(appConfig.readFromConfig("key"), appConfig.readFromConfig("value"), "Content-Type", "application/json").and().body(payloadUtilities.getUserPayload()).when().post("/user").then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(description = "Get: View user info")
    public void getUser() {
        RestAssured.baseURI = appConfig.readFromConfig("baseUrl");
        Response response = RestAssured.given().header(appConfig.readFromConfig("key"), appConfig.readFromConfig("value")).when().get("/user/" + appConfig.readFromConfig("username")).then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Put: Update user info")
    public void updateUser() {

        String updatedInfo = "{\"id\": 1025,\r\n"
                + "\"username\": \"Emma.5\",\r\n"
                + "\"firstName\": \"Emma\",\r\n"
                + "\"lastName\": \"Brown\",\r\n"
                + "\"email\": \"emma@email.com\",\r\n"
                + "\"phone\":\"8078652021\",\r\n"
                + "\"userStatus\":1"
                + "}";

        RestAssured.baseURI = appConfig.readFromConfig("baseUrl");

        Response response = RestAssured.given().headers(appConfig.readFromConfig("key"), appConfig.readFromConfig("value"), "Content-Type", "application/json").and().body(updatedInfo).when().put("/user/" + appConfig.readFromConfig("username")).then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Delete: Delete created user")
    public void deleteUser() {
        RestAssured.baseURI = appConfig.readFromConfig("baseUrl");
        Response response = RestAssured.given().header(appConfig.readFromConfig("key"), appConfig.readFromConfig("value")).when().delete("/user/" + appConfig.readFromConfig("username")).then().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);

    }


}
