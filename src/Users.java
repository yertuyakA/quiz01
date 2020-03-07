import java.util.List;

/**
 * Created by MSovet on 05.03.2020.
 */
public class Users {

    private String login;
    private String password;
    private String nickname;
    private int maxScore;
    private List<Integer> scorelist;

    void setLogin(String login) {
        this.login = login;
    }
    void setPassword(String password){this.password = password;}
    void setNickname(String nickname){this.nickname = nickname;}
    void setMaxScore(int maxScore){this.maxScore = maxScore;}
    void setScorelist(List <Integer> scorelist) {
        this.scorelist = scorelist;
    }

    String getLogin () {return login;}
    String getPassword () {return password;}
    String getNickname () {return nickname;}
    int getMaxScore () {return maxScore;}

    public List<Integer> getScorelist() {
        return scorelist;
    }
}
