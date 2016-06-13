package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Question;

public class CreateQuestion {
	String [] respuestas = {"franco"," mario", "mariano", "juan"};
     Question q = new Question("�tu nombre es",respuestas,"franco");
	@Test
	public void test() {
		assertEquals("franco",q.getTrueAnswer());
		assertNotNull("el objeto es null",new Question("�tu nombre es",respuestas,"franco"));
		assertEquals("�tu nombre es",q.getAnswer());
		assertEquals("franco",q.getAnswer()[0]);
		assertEquals("mario",q.getAnswer()[1]);
		assertEquals("mariano",q.getAnswer()[2]);
		assertEquals("juan",q.getAnswer()[3]);
	}
	

}
