import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredBase {

    public Response TestAPI(){
        Response response = RestAssured.given().when().
                get("https://www.breakingbadapi.com/api/characters/").
                then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
        return response;
    }
}
