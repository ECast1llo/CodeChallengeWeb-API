import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APIMain extends RestAssuredBase{

    RestAssuredBase restAssuredBase = new RestAssuredBase();

    @Test
    public void WWBirthday (){
        System.out.println(restAssuredBase.TestAPI(1).getBody().path("birthday").toString());
    }

    @Test
    public void PrintAllCharacters(){
        for(int i=1; i<=57; i++) {
            Character character = new Character();
            Response response = restAssuredBase.TestAPI(i);
            character.setChar_id(response.getBody().path("char_id"));
            character.setName(response.getBody().path("name").toString());
            character.setBirthday(response.getBody().path("birthday"));
            character.setOccupation(response.getBody().path("occupation"));
            character.setImg(response.getBody().path("img").toString());
            character.setStatus(response.getBody().path("status").toString());
            character.setAppearance(response.getBody().path("appearance"));
            character.setPortrayed(response.getBody().path("portrayed"));
            character.setCategory(response.getBody().path("category").toString());
            character.setBetter_call_saul_appearance(response.getBody().path("better_call_saul_appearance"));
            System.out.println("Character name: " + character.getName());
            System.out.println("Portrayed:  " + character.getPortrayed());
            System.out.println("-------------------------------------");
        }
    }


}
