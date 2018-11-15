package web.learn;

import com.google.gson.JsonArray;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import functional.FunctionalClass;
import org.json.JSONArray;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static dataCreation.VariableLibrary.OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class GarageResultTest extends FunctionalClass {

    @Test
    public void basicPingTest() {
        System.out.println(System.getenv("server.host"));
        //given().when().get("http://

        // Specify the base URL to the RESTful web service
        //RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.get("/Hyderabad");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        given().when().get(RestAssured.baseURI).then().statusCode(OK);
        System.out.println("s");
        String habr = given().when().get("http://restcountries.eu/rest/v1/name/russia").body().asString();
        System.out.println(habr);
        JSONArray jsonResponse = new JSONArray(habr);
        String capital = jsonResponse.getJSONObject(0).getString("name");
        System.out.println(capital);
        given().contentType("application/json").when().get("http://restcountries.eu/rest/v1/name/russia").then().statusCode(OK).assertThat()
                .body("name", equalTo("[Russia]"));
    }
}

