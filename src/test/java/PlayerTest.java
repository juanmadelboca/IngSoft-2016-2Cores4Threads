package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class PlayerTest {

	QuestionModel model= new QuestionModel();
	@Test
	public void setPlayerTest1() {
		model.setName("Juan");
		assertEquals(model.getName(),"Juan");
	}
	@Test
	public void setPlayerTest2() {
		model.setName("FrancoDiloGamer12231");
		assertEquals(model.getName(),"FrancoDiloGamer12231");
	}
	@Test
	public void setPlayerTest3() {
		model.setName("asdas");
		assertNotEquals(model.getName(),"Juan");
	}


}
