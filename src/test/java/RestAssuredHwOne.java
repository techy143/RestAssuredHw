import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredHwOne {

        JsonPath jsonPath = null;

        @Test
        public void apiTestOne(){
            //Specify Base URI......
            RestAssured.baseURI= "https://www.transparency.treasury.gov/";

            //Request Object.....
            RequestSpecification requestSpecification = RestAssured.given();

            //Response Object.....
            Response response = requestSpecification.get("services/api/fiscal_service/v1/accounting/od/debt_to_penny");

            //Status Code Validation.....
            int responseCode = response.statusCode();
            System.out.println("Status Code is: " + responseCode);
            Assert.assertEquals(responseCode, 200);

            jsonPath = response.getBody().jsonPath();

            String firstCourse = jsonPath.getString("data.debt_held_public_amt");
            System.out.println(firstCourse);
            System.out.println("Passed Successfully...");

        }
    }