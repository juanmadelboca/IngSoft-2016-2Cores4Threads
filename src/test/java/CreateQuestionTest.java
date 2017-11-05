package test.java;

import static org.junit.Assert.*;
import main.java.Question;

import org.junit.Test;

public class CreateQuestionTest {
	String [] respuestas = {"franco"," mario", "mariano", "juan"};
	String a = "tu nombre es?";
	String c = "franco";
    @Test
	public void testCorrecta() {
    	 Question q = null;
		try {
			q = new Question(a,respuestas,c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("franco",q.getTrueAnswer());
	}
	@Test
	public void testIncorrecta() {
		 Question q = null;
			try {
				q = new Question(a,respuestas,c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertFalse("mario"==q.getTrueAnswer());
	}
	@Test
	public void testGetQuestion(){
		 Question q = null;
			try {
				q = new Question(a,respuestas,c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertEquals("tu nombre es?",q.getQuestion());
	}
	@Test
    public void testCreacionDeObjeto(){
		 Question q = null;
			try {
				q = new Question(a,respuestas,c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNotNull("el objeto es null",q);	
    }
	@Test
	public void testNullParameters1(){
		try {
		    @SuppressWarnings("unused")
			Question q = new Question(null,respuestas,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
		} 
	
	@Test
	public void testNullParameters2(){
		try {
		    @SuppressWarnings("unused")
			Question q = new Question(a,null,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
	}
	@Test
	public void testNullParameters3(){
		try {
		    @SuppressWarnings("unused")
			Question q = new Question(a,respuestas,null);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testNullParameters4(){
		try {
			String[] r =  {""," mario", "mariano", "juan"};
			@SuppressWarnings("unused")
			Question q = new Question(a,r,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testNullParameters5(){
		try {
			String[] r =  {"franco","", "mariano", "juan"};
			@SuppressWarnings("unused")
			Question q = new Question(a,r,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testNullParameters6(){
		try {
			String[] r =  {"franco","mario", "", "juan"};
			@SuppressWarnings("unused")
			Question q = new Question(a,r,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testNullParameters7(){
		try {
			String[] r =  {"franco","mario", "mariano", ""};
			@SuppressWarnings("unused")
			Question q = new Question(a,r,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}

	@Test
	public void testNullQuestionParameter(){
		try {
			String[] r =  {"franco","mario", "mariano", "messi"};
			@SuppressWarnings("unused")
			Question q = new Question("",r,c);
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testNullTrueAnswerParameter(){
		try {
			String[] r =  {"franco","mario", "mariano", "messi"};
			@SuppressWarnings("unused")
			Question q = new Question(a,r,"");
		    fail("Se esperaba excepcion Exception");
		  } catch(Exception e) {}
}
	@Test
	public void testCreateNullQuestion(){
			Question q = new Question();
			assertTrue(q!=null);
}
	@Test
	public void testGetAnswer() {
   	 Question q = null;
		try {
			q = new Question(a,respuestas,c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(respuestas==q.getAnswer());
	}
	
}
