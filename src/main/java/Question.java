package main.java;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Question implements Serializable {

    public Question() {
    }

    private String question;

    private String[] answer;

    private String trueAnswer;

    public Question(String question, String[] answer, String trueAnswer) throws Exception {
        // TODO implement here
    	if (question.equals("") || answer[0].equals("") ||
       			answer[1].equals("") || answer[2].equals("") ||
       			answer[3].equals("") || trueAnswer.equals("")) {
    		
            throw new Exception();
    	} else {
    		this.question = question;
            this.answer = answer;
            this.trueAnswer = trueAnswer;
        }
    }

    public String getQuestion() {
        // TODO implement here
        return question;
    }

    public String[] getAnswer() {
        // TODO implement here
        return answer;
    }

    public String getTrueAnswer() {
        // TODO implement here
        return trueAnswer;
    }

}
