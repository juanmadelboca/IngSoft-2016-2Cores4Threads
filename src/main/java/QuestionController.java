package main.java;

public class QuestionController implements ControllerInterface {
	QuestionModelInterface model;
	DJView view;
	QuestionView qview;

    public QuestionController(QuestionModelInterface model) {
    	this.model = model;
		view = new DJView(this, new QuestionAdapter(model));
        view.createView();
        view.createControls();
        view.setTitle("QuestionView");
        model.initialize();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
        qview= new QuestionView(this, model);

    }

	public void start() {
    	model.nextQuestion();
        
    }

    public void stop() {
    }

    public void increaseBPM() {
        model.increaseTime();
    }

    public void decreaseBPM() {
        model.decreaseTime();
    }

    public void setBPM(int bpm) {
        model.setTime(bpm);
    }

    public boolean send(String quest) {
    	boolean correctAnswer= model.compare(quest);
    	model.nextQuestion();
        return correctAnswer;
    }

    public void skip() {
        model.nextQuestion();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void addQuestion(String question, String[] answer, String trueAnswer) {
    	Question quest= new Question(question,answer,trueAnswer);
        model.addQuestion(quest);
    }
    public void showBeatBar(boolean show)
    {
    	view.showBeatBar(show);
    }

}