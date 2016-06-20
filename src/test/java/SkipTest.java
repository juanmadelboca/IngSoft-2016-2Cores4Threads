package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class SkipTest {

	@Test
	public void SkipAlltest() {
		//skip no es mas que un next question sin comparar previamente

		QuestionModel model= new QuestionModel();
		while(!model.finish){
		model.nextQuestion();}
		assertTrue(model.getScore()==0);
		
	}	
	@Test
	public void SkipOnetest() {
		//testeo que skip no cambie el valor de puntaje

		QuestionModel model= new QuestionModel();
		model.increaseScore();
		model.nextQuestion();
		assertTrue(model.getScore()==100);
		
	}
	
	@Test
	public void SkipOnetest2() {
		//testeo que skip no cambie el valor de puntaje

		QuestionModel model= new QuestionModel();
		model.nextQuestion();
		assertFalse(model.getScore()==100);
		
		
	}
	
	
	
	

}
