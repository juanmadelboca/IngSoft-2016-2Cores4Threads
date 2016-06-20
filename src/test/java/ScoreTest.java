package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class ScoreTest {

	@Test
	public void IncreaseScoreTest1() {
		QuestionModel model= new QuestionModel();
		model.increaseScore();
		assertEquals(model.getScore(),100);
	}

	@Test
	public void IncreaseScoreTest2() {
		QuestionModel model= new QuestionModel();
		model.increaseScore();
		model.increaseScore();
		assertFalse(model.getScore()==100);
	}
	@Test
	public void IncreaseScoreTest3() {
		QuestionModel model= new QuestionModel();
		for(int i=0;i<10;i++)
		model.increaseScore();
		assertTrue(model.getScore()==1000);
	}
	@Test
	public void IncreaseScoreTestRestart() {
		//Caso si el usuario reinicia el juego
		QuestionModel model= new QuestionModel();
		model.increaseScore();
		model.increaseScore();
		model= new QuestionModel();
		assertTrue(model.getScore()==0);
	}
}
