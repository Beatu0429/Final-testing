/*      Copyright 2022 Mohammad Faisal Khatri

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/

package com.example.beatriznieves.Tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic ("Rest Assured POC - Example Tests")
@Feature ("Performing different API Tests using Rest-Assured")
public class AssuredTest {


    @DataProvider (name = "getUserData")
    public Iterator<Object[]> getUsers () {
        final List<Object[]> getData = new ArrayList<> ();
        getData.add (new Object[] { 2 });
        return getData.iterator ();
    }

    @Test
    public void testUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test
    public void testUserFirstName() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void testDeleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat ()
                .statusCode(204)
                .log().everything();
    }

    @Test
    public void logInUser() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "cityslicka");

        given()
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .assertThat ()
                .statusCode(200)
                .body("token", notNullValue())
                .log().everything();
    }


}