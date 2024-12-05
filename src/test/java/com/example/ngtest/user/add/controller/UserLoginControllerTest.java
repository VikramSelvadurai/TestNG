package com.example.ngtest.user.add.controller;

import com.example.ngtest.user.add.enums.UserStatus;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserLoginControllerTest {

    private static final String BASE_URI = "http://localhost:8080/TestNG/user";

    @Test
    public void testAddUser() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("username", "Rangaraj");
        jsonObject.put("password", "123456");
        jsonObject.put("firstName", "vik");
        jsonObject.put("lastName", "ram");
        jsonObject.put("email", "vikram.selvaduraiSetting@gmail.com");
        jsonObject.put("userStatus", UserStatus.ACTIVE);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when()
                .post("/add-user")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUpdateUser() {
    }

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testGetUser() {
    }
}