package main.java;
  
public class HeartTestDrive {

    @SuppressWarnings("unused")
	public static void main (String[] args) {
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface model = new HeartController(heartModel);
    }
}
