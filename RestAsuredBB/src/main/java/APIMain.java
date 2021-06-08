import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APIMain extends RestAssuredBase{

    RestAssuredBase restAssuredBase = new RestAssuredBase();

    @Test
    public void BreakingBadAPI(){
        Response response = restAssuredBase.TestAPI();
        Character[] characters = response.jsonPath().getObject("",Character[].class);
        for (Character cr:characters){
            if (cr.getChar_id().equals("1")){
                System.out.println(cr.getBirthday());
                System.out.println("\n");
            }
            System.out.println("Character name: " + cr.getName());
            System.out.println("Portrayed:  " + cr.getPortrayed());
            System.out.println("-------------------------------------");
        }
    }
}
