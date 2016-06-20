package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class QuestionCorrectorTest {

	@Test
	public void CorrectorTest1() {

		QuestionModel model= new QuestionModel();
		model.initialize();
		model.nextQuestion();
		
		String respuesta=model.getTrueAnswer();
		boolean bool=model.compare(respuesta);
		assertTrue(bool);
	}
	
	@Test
	public void CorrectorTest2() {

		QuestionModel model= new QuestionModel();
		model.initialize();
		model.nextQuestion();
		boolean falsa=false;
		int i=0;
		String[] respuestas=model.getAnswer();
		while(falsa){
			if(!respuestas[i].equals(model.getTrueAnswer())){
				falsa=true;
			}else
				i++;
			
		}
		
		boolean bool=model.compare(respuestas[i]);
		assertFalse(bool);
	}

}
