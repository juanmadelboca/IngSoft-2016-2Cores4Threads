package main.java;

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
        return model.getTime();
    }

    public void registerObserver(BeatObserver o) {
        model.registerObserver(o);
    }

    public void removeObserver(BeatObserver o) {
        model.removeObserver(o);
    }

    public void registerObserver(BPMObserver o) {
        model.registerObserver(o);
    }

    public void removeObserver(BPMObserver o) {
        model.removeObserver(o);
    }
    public QuestionModelInterface getModel(){
		return model;
	}

}