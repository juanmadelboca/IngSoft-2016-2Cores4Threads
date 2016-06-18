package main.java;

public class multiViewTestDrive {
	public static void main(String[] args) {
		QuestionModel modelQ = new QuestionModel();
		HeartModel modelH = HeartModel.getInstance();
		BeatModel modelB = new BeatModel();
		
		@SuppressWarnings("unused")
		QuestionController QController= new QuestionController(modelQ);
		@SuppressWarnings("unused")
		HeartController HController = new HeartController(modelH);
		@SuppressWarnings("unused")
		BeatController BController = new BeatController(modelB);
	}
}
