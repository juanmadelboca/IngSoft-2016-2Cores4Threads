package main.java;
import java.util.*;

public class QuestionModel implements QuestionModelInterface {

    public QuestionModel() {
    }

    private String player;

    public DataBase base;





    public void initialize() {
        // TODO implement here
    }

    public String getQuestion() {
        // TODO implement here
        return "";
    }

    public String[] getAnswer() {
        // TODO implement here
        return null;
    }

    public String getTrueAnswer() {
        // TODO implement here
        return "";
    }

    public void setName(String name) {
        // TODO implement here
    }

    public String getName() {
        // TODO implement here
        return "";
    }

    public String[] getScore() {
        // TODO implement here
        return null;
    }

    public boolean compare(String quest) {
        // TODO implement here
        return true;
    }

    public void setTime(int time) {
        // TODO implement here
    }

    public void increaseTime() {
        // TODO implement here
    }

    public void decreaseTime() {
        // TODO implement here
    }

    public void registerObserver(BeatObserver o) {
        // TODO implement here
    }

    public void removeObserver(BeatObserver o) {
        // TODO implement here
    }

    public void registerObserver(BPMObserver o) {
        // TODO implement here
    }

    public void removeObserver(BPMObserver o) {
        // TODO implement here
    }

    public void registerObserver(QuestionObserver o) {
        // TODO implement here
    }

    public void removeObserver(QuestionObserver o) {
        // TODO implement here
    }
}