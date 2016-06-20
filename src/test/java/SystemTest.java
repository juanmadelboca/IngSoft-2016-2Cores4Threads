package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionController;
import main.java.QuestionModel;

public class SystemTest {

	@Test
	public void GameSystemTest() {
		
		QuestionModel model = new QuestionModel();
		QuestionController controller= new QuestionController(model);
		controller.setName("PACO");
		controller.start();
		String respuesta=model.getTrueAnswer();
		controller.send(respuesta);
		
		respuesta="Dulce Leche123";
		controller.send(respuesta);
		
		respuesta=model.getTrueAnswer();
		controller.send(respuesta);
		
		while(!model.finish){
			controller.skip();
		}
		assertEquals(model.getScore(),200);
		assertEquals(model.getName(),"PACO");
		
	}

}
