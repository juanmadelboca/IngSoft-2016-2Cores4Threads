package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class TimeTest {
	QuestionModel model= new QuestionModel();
	@Test
	public void setTimTest1() {
		model.setTime(1);
		assertEquals(model.getTime(),1);
	}

}
