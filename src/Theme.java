import java.util.ArrayList;
import java.util.List;

public abstract class Theme {

    private List<QuestionAnswers> questions;

    public abstract void checkAnswers();

    void setQuestionList(List<QuestionAnswers> questions) {
        this.questions = questions;
    }

    public List<QuestionAnswers> getQuestion() {
        return questions;
    }

    String title;
    void setTitle(String title){
        this.title = title;
    }

    String getTitle(){
        return title;
    }

}
