import java.util.List;

/**
 * Created by MSovet on 05.03.2020.
 */
public class User {

    private String login;
    private String password;
    private String nickname;
    private int maxScore;
    private int id;
    private List<Integer> scorelist;

    void setLogin(String login) {
        this.login = login;
    }
    void setPassword(String password){
        this.password = password;
    }
    void setNickname(String nickname) {
        this.nickname = nickname;
    }
    void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
    void setId(int id){
        this.id = id;
    }
    void setScorelist(List <Integer> scorelist)
    {
        this.scorelist = scorelist;
    }

    String getLogin () {
        return login;
    }
    String getPassword () {
        return password;
    }
    String getNickname () {
        return nickname;
    }
    int getMaxScore () {
        return maxScore;
    }
    int getId(){
        return id;
    }

    public List<Integer> getScorelist() {
        return scorelist;
    }

    @Override
    public String toString() {
        return "Id"+this.id +"nickname" + this.nickname;
    }
}
