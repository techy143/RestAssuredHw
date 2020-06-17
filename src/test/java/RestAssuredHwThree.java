import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredHwThree {

    JsonPath jsonPath = null;

    @Test
    public void apiTestThree(){

        //Specify Base URI......
        RestAssured.baseURI = "https://www.transparency.treasury.gov/";

        //Request Object.....
        RequestSpecification requestSpecification = RestAssured.given();

        //Response Object.....
        Response response = requestSpecification.get("/services/api/fiscal_service/v1/accounting/od/utf_qtr_yields");

        //Status Code Validation.....
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+ statusCode);
        Assert.assertEquals(statusCode,200);

        jsonPath = response.getBody().jsonPath();

        String testThreeString = jsonPath.getString("data.quarter_desc");
        System.out.println(testThreeString);
        System.out.println("Passed Successfully...");
    }
}