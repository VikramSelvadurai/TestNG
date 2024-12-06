package com.example.ngtest.user.add.controller;

import com.example.ngtest.user.add.response.UserResponseBean;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;
@SpringBootTest
@ActiveProfiles("test")
public class UserLoginControllerTest {

    Gson gson = new Gson();

    private static final String BASE_URI = "http://localhost:8080/TestNG/user";
    private static final String ADD_USER_REQUEST_BEAN = "{\n" +
            "  \"username\": \"svikdfgsdges\",\n" +
            "  \"password\": \"12345\",\n" +
            "  \"firstName\": \"vickey\",\n" +
            "  \"lastName\": \"Selvadurai\",\n" +
            "  \"email\": \"vikram.selvadurai@gmail.com\",\n" +
            "  \"userStatus\": \"ACTIVE\"\n" +
            "}";
    private static final String UPDATE_USER_REQUEST_BEAN = "{\n" +
            "  \"username\": \"fhhgfnfgjgf\",\n" +
            "  \"password\": \"123536567\",\n" +
            "  \"firstName\": \"vickey\",\n" +
            "  \"lastName\": \"Selvadurai\",\n" +
            "  \"email\": \"vikram.selvadurai@yahoo.com\",\n" +
            "  \"userStatus\": \"ACTIVE\"\n" +
            "}";
    private UUID UserId = UUID.randomUUID();

    @Test(priority = 1)
    public void testAddUser() {

        String response = RestAssured.given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(ADD_USER_REQUEST_BEAN)
                .when()
                .post("/add-user")
                .getBody().asString();

        UserResponseBean userResponseBean = gson.fromJson(response, UserResponseBean.class);
        UserId = userResponseBean.getUserId();
        Assert.assertEquals(userResponseBean.getUsername(), "svikdfgsdges");
    }

    @Test(priority = 2)
    public void testUpdateUser() {
        String response = RestAssured.given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(UPDATE_USER_REQUEST_BEAN)
                .when()
                .patch("/update-user/"+UserId)
                .getBody().asString();
        UserResponseBean userResponseBean = gson.fromJson(response, UserResponseBean.class);
        Assert.assertEquals(userResponseBean.getUsername(), "fhhgfnfgjgf");
    }

    @Test(priority = 4)
    public void testDeleteUser() {

        RestAssured.given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .when()
                .delete("/delete-user/" + UserId)
                .then().statusCode(200);
    }

    @Test(priority = 3)
    public void testGetUser() {

        String response = RestAssured.given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .when()
                .get("/get-user/"+UserId)
                .getBody().asString();
        UserResponseBean userResponseBean = gson.fromJson(response, UserResponseBean.class);
        Assert.assertEquals(userResponseBean.getUsername(), "fhhgfnfgjgf");
    }
}