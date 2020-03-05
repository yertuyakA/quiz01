import java.util.HashMap;

public class QuestionAnswers {
    private HashMap<String,String> scoreAnswerMap = new HashMap<>();

    void setScoreAnswerMap(HashMap<String,String> scoreAnswerMap){
        this.scoreAnswerMap = scoreAnswerMap;
    }

    public HashMap<String, String> getScoreAnswerMap() {
        return scoreAnswerMap;
    }
}
