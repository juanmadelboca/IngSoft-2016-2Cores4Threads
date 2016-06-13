package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.QuestionModel;

public class TimeTest {
	QuestionModel model= new QuestionModel();
	@Test
	public void setTimeTest1() {
		model.setTime(1);
		assertEquals(model.getTime(),1);
	}
	@Test
	public void setTimeTest2() {
		model.setTime(932);
		assertEquals(model.getTime(),932);
	}
	@Test
	public void setTimeTest3() {
		model.setTime(13);
		assertFalse(model.getTime()==1);
	}
	@Test
	public void setTimeTest4() {
		model.setTime(-5);
		assertFalse(model.getTime()==-15);
	}
	@Test
	public void decreaseTimeTest1() {
		model.setTime(10);
		model.decreaseTime();
		assertFalse(model.getTime()==10);
	}
	@Test
	public void decreaseTimeTest2() {
		model.setTime(10);
		model.decreaseTime();
		assertEquals(model.getTime(),9);
	}
	@Test
	public void increaseTimeTest1() {
		model.setTime(10);
		model.increaseTime();
		assertEquals(model.getTime(),11);
	}
	@Test
	public void increaseTimeTest2() {
		model.setTime(10);
		model.increaseTime();
		assertFalse(model.getTime()==10);
	}


}
