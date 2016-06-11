package main.java;
import java.util.*;

public class Question {

    public Question() {
    }

    private String question;

    private String[] answer;

    private String trueAnswer;

    public void Question(String question, String[] answer, String trueAnswer) {
        // TODO implement here
        this.question=question;
        this.answer=answer;
        this.trueAnswer=trueAnswer;
    }

    public String getQuestion() {
        // TODO implement here
        return question;
    }

    public String[] getAnswer() {
        // TODO implement here
        return answer;
    }

    public String getTrueAnswer() {
        // TODO implement here
        return trueAnswer;
    }

}
