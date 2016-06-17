package main.java;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new HeartView(this,new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public HeartController(HeartModelInterface model, DJView view) {
		this.model = (HeartModelInterface) model;
		this.view = view;
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}

	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		model = HeartModel.getInstance();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}
