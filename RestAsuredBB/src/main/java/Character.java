import java.util.List;

public class Character {

    private List<Integer> char_id;
    private String name;
    private List<String> birthday;
    private List<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private List<Integer> appearance;
    private List<String> portrayed;
    private String category;
    private List<Integer> better_call_saul_appearance;

    public List<Integer> getChar_id() {
        return char_id;
    }

    public void setChar_id(List<Integer> char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBirthday() {
        return birthday;
    }

    public void setBirthday(List<String> birthday) {
        this.birthday = birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public void setAppearance(List<Integer> appearance) {
        this.appearance = appearance;
    }

    public List<String> getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(List<String> portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }

    public void setBetter_call_saul_appearance(List<Integer> better_call_saul_appearance) {
        this.better_call_saul_appearance = better_call_saul_appearance;
    }
}
