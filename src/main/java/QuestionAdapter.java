package main.java;
import java.util.*;

public class QuestionAdapter implements BeatModelInterface {
	
	QuestionModelInterface model;

    public QuestionAdapter(QuestionModelInterface model) {
    	this.model= model;
    }


    public void initialize() {
        // TODO implement here
    }

    public void on() {
        // TODO implement here
    }

    public void off() {
        // TODO implement here
    }

    public void setBPM(int bpm) {
        // TODO implement here
    }

    public int getBPM() {
        // TODO implement here
        return 0;
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

}