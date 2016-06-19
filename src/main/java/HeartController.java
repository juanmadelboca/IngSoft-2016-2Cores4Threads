package main.java;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new HeartView(this,new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.setTitle("HeartView");
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
 	
 	public void showBeatBar(boolean show)
    {
    	view.showBeatBar(show);
    }
 	
 	public void showController(boolean show)
 	{
 		view.showControl(show);
 	}
}
