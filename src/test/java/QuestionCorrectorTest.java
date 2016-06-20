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

		long tiempoInicio = System.currentTimeMillis();
		boolean bool=model.compare(respuesta);
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		assertTrue(bool);
		assertTrue(totalTiempo<=2000);
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
		long tiempoInicio = System.currentTimeMillis();
		boolean bool=model.compare(respuestas[i]);
		long totalTiempo = System.currentTimeMillis() - tiempoInicio;
		assertFalse(bool);
		assertTrue(totalTiempo<=2000);
	}

}
