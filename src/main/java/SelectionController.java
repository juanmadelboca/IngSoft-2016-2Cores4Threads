package main.java;


public class SelectionController implements ControllerInterface {
	QuestionModelInterface model;
	DJView view;

	public SelectionController(QuestionModelInterface model) {
		view = new SelectionView(this, new QuestionAdapter(model));
		view.createView();
		view.createControls();
		model.initialize();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		
	}

}
