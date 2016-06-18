package main.java;

public class SelectionTestDrive {

	public static void main(String[] args)
	{
		BeatModelInterface model= new BeatModel();
		ControllerInterface controller= new BeatController(model);
		SelectionView view = new SelectionView(controller,model);

		
	}

}
