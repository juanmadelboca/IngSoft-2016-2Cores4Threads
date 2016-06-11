package main.java;
import java.util.*;

public interface QuestionModelInterface {

    void initialize();

    String getQuestion();

    String[] getAnswer();

    String getTrueAnswer();

    void setName(String name);

    String getName();

    String[] getScore();

    boolean compare(String quest);

    void setTime(int time);

    void increaseTime();

    void decreaseTime();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);

    void registerObserver(QuestionObserver o);

    void removeObserver(QuestionObserver o);

}