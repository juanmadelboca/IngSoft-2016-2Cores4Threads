package test.java;

import static org.junit.Assert.*;
import main.java.Question;
import main.java.QuestionModel;

import org.junit.Test;

public class generarQuestionAleatoriaTest {
QuestionModel m ;
	public generarQuestionAleatoriaTest() {
		m = new QuestionModel();
	}


	@Test
	public void test() {
		QuestionModel m1 = new QuestionModel();
		int i = 0;
		boolean flag = false;
		for(Question q:m1.getQuestions()){
			m.nextQuestion();
			if(m.getQuestion()!=q.getQuestion()){
			flag = true;
			}
			else 
				flag = false;
		    i++;
		    assertTrue(flag);
	}
	}
}
