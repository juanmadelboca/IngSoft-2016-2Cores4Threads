package main.java;
  
public class DJTestDrive {

    @SuppressWarnings("unused")
	public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
