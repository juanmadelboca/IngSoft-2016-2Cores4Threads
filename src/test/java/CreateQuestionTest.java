/*package test.java;

import static org.junit.Assert.*;
import main.java.Question;

import org.junit.Test;

public class CreateQuestionTest {
	String [] respuestas = {"franco"," mario", "mariano", "juan"};
     Question q = new Question("tu nombre es?",respuestas,"franco");
	@Test
	public void testCorrecta() {
		assertEquals("franco",q.getTrueAnswer());
	}
	@Test
	public void testIncorrecta() {
		assertFalse("mario"==q.getTrueAnswer());
	}
	@Test
	public void testGetAnswer(){
		assertEquals("tu nombre es?",q.getQuestion());
	}
	@Test
    public void testCreacionDeObjeto(){
    assertNotNull("el objeto es null",q);	
    }
	@Test
	public void testNullParameters1(){
		Question q1 = new Question(null,null,null);
		assertNull("el objeto es null",q1.getAnswer());
	}
	@Test
	public void testNullParameters2(){
		Question q1 = new Question(null,null,null);
		assertNull(q1.getQuestion());
	}
	@Test
	public void testNullParameters3(){
		Question q1 = new Question(null,null,null);
		assertNull("el objeto es null",q1.getTrueAnswer());
	}
}*/
