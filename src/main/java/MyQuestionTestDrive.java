package main.java;

public class MyQuestionTestDrive {

        @SuppressWarnings("unused")
		public static void main(String[] args) {
			QuestionModel model = new QuestionModel();
			QuestionController controller= new QuestionController(model,"uniqueView");

		}
}


