package main.java;

 
public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
        view.createView();
        view.createControls();
        view.setTitle("BeatView");
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		this.model.initialize();
	}
	
	public BeatController(BeatModelInterface model, DJView view){
		this.model=model;
		this.view = view;
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
 	
 	public void showBeatBar(boolean show)
    {
    	view.showBeatBar(show);
    }
 	
 	public void showControl(boolean show)
 	{
 		view.showControl(show);
 	}
}
