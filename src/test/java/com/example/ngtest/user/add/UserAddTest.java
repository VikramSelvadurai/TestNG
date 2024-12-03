//package com.example.ngtest.user.add;
//
//import net.minidev.json.JSONObject;
//import net.minidev.json.parser.JSONParser;
//import net.minidev.json.parser.ParseException;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class UserAddTest {
//
//
//    public void UserAddTest() {
//        String addURI = "http://localhost:8082/test-ng/api/user/add-user";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", "application/json");
//        headers.add("Content-Type", "application/json");
//
//
//        String jsonBody = "\"\\\"username\\\":\\\"vikram\\\",\\\"password\\\":\\\"12345\\\",\\\"firstName\\\":\\\"vickey\\\",\\\"lastName\\\":\\\"Selvadurai\\\",\\\"email\\\":\\\"vikram.selvadurai@gmail.com\\\",\\\"userStatus\\\":\\\"ACTIVE\\\"}\"";
//
//        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response =restTemplate.postForEntity(addURI, entity, String.class);
//
//        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
//        Assert.assertTrue(getuserNameFromResponse(response.getStatusCode().toString()).contains("vikram"));
//
//        ;
////        JSONParser parser = new JSONParser(); // Instantiate JSONParser object
////        JSONObject jsonResponseObject = new (JSONObject) parser.parse(String.valueOf(response.hasBody()));
////Parse jsonString i.e. Response body string in json format to JSON object
////        String employeeId = jsonResponseObject.get("id").toString(); // Get id attribute
//
//
////        Assert.assertTrue(response.hasBody());
//
//
//
//
//    }
//
//    public static String getuserNameFromResponse(String json) {
//        JSONParser parser = new JSONParser();
//        JSONObject jsonResponseObject = new JSONObject();
//        Object obj = new Object();
//        try {
//            obj = parser.parse(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        jsonResponseObject = (JSONObject) obj;
//        String id = jsonResponseObject.get("username").toString();
//        return id;
//    }
//
//
//
//
//
//
//}
