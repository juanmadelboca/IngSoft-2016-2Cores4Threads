package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionController;
import main.java.QuestionModel;

public class SystemTest {

	@Test
	public void GameSystemTest() {
		long initialTime1 = System.currentTimeMillis();
		QuestionModel model = new QuestionModel();
		//QuestionController controller= new QuestionController(model);

        model.initialize();
        //Testeo que haya cargado la base de preguntas
        assertFalse(model.getQuestions().isEmpty());
        
		model.setName("PACO");
		model.initialize();
		int initialTime=model.getTime();
        model.nextQuestion();
        long finalTime1 = System.currentTimeMillis() - initialTime1;
        assertTrue(finalTime1<=1000);
		String answer=model.getTrueAnswer();
		model.compare(answer);
    	model.nextQuestion();
    	
    	boolean isFalse=false;
		int i=0;
		String[] answers=model.getAnswer();
		while(isFalse){
			if(!answers[i].equals(model.getTrueAnswer())){
				isFalse=true;
			}else
				i++;
			
		}
		answer=answers[i];
		model.compare(answer);
    	model.nextQuestion();
		
    	answer=model.getTrueAnswer();
		model.compare(answer);
    	model.nextQuestion();
    	
		while(!model.finish){
			model.nextQuestion();
		}
		int finalTime=model.getTime();
		assertFalse(initialTime==finalTime);
		assertEquals(model.getScore(),200);
		assertEquals(model.getName(),"PACO");
		
	}

}
