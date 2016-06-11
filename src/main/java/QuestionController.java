package main.java;
import java.util.*;

public class QuestionController implements ControllerInterface {
	QuestionModelInterface model;
	DJView view;
	QuestionView qview;

    public QuestionController(QuestionModelInterface model) {
    	this.model = model;
		view = new DJView(this, new QuestionAdapter(model));
        view.createView();
        view.createControls();

    }


    public void start() {
        // TODO implement here
    }

    public void stop() {
        // TODO implement here
    }

    public void increaseBPM() {
        // TODO implement here
    }

    public void decreaseBPM() {
        // TODO implement here
    }

    public void setBPM(int bpm) {
        // TODO implement here
    }

    public boolean send(String quest) {
        // TODO implement here
        return true;
    }

    public void skip() {
        // TODO implement here
    }

    public void setName(String name) {
        // TODO implement here
    }

    public void addQuestion(Question quest) {
        // TODO implement here
    }

}