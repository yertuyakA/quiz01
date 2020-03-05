import java.util.ArrayList;
import java.util.List;

public class Theme {
    private List<String> questionList = new ArrayList<>();

    public void checkAnswer() {

    }
    void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    List<String> getQuestionList() {
        return questionList;
    }

}
