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
    public void testRegister() {
        given()
                .when()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    public void testNewAccount() {

        given()
                .contentType(ContentType.JSON)
                .with().queryParam("customerId", 12767).queryParam("newAccountType", 1)
                .queryParam("fromAccountId", 14010).auth().basic("AdriYcerebro", "213167")
                .when()
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAccountOverview() {
        given()
                .contentType(ContentType.JSON)
                .with().auth().basic("AdriYcerebro", "213167")
                .when()
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/customers/12767/accounts")
                .then()
                .statusCode(200);
    }

    @Test
    public void downloadImages() {

        given()
                .contentType(ContentType.JSON)
                .with().queryParam("fromAccountId", 14010).queryParam("toAccountId", 14454)
                .queryParam("amount", 2).auth().basic("AdriYcerebro", "213167")
                .when()
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/transfer")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAccountMonth() {
        given()
                .contentType(ContentType.JSON)
                .with().auth().basic("AdriYcerebro", "213167")
                .when()
                .get("https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All")
                .then()
                .statusCode(200);
    }


}