package main.java;
import java.io.*;
import java.util.*;

public class QuestionModel implements QuestionModelInterface {

	private String player;
	private ArrayList<Question> questions;
    private HashMap<String,Integer> highScores;
    private	Question question;
    private int time;

	public QuestionModel() {
		questions= new ArrayList<Question>();
		highScores= new HashMap<String,Integer>();
	}
	
	private void load() {
		boolean carga=true;
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("base.obj"));
		} catch (IOException e) {
			System.out.println("No existe la base");
			e.printStackTrace();
			carga=false;
		}
		try {
			questions = (ArrayList<Question>) entrada.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No existe el objeto en la base");
			e.printStackTrace();
			carga=false;
		}

		try {
			entrada.close();
		} catch (IOException e) {
			System.out.println("No puedo cerrar el objeto");
			e.printStackTrace();
			carga=false;
		}

		if (carga)
			System.out.println("Carga con exito");
	}
    

	private void save(){
		boolean guardar=true;
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("base.obj"));
		} catch (IOException e) {
			System.out.println("No existe la base");
			e.printStackTrace();
		}
	      try {
			salida.writeObject(questions);
		} catch (IOException e) {
			System.out.println("No se pudo guardar el objeto");
			e.printStackTrace();
		}
	      try {
			salida.close();
		} catch (IOException e) {
			System.out.println("No se pudo cerrar el objeto");
			e.printStackTrace();
		}
		if (guardar)
			System.out.println("Guardado con exito");
    }
    
	public void addQuestion(Question quest){
		questions.add(quest);
		save();
    	
    }

	public void initialize() {
		load();
	}

	public String getQuestion() {
		Random rnd = new Random();
		int valor= (int)(rnd.nextDouble() * questions.size());
		question= questions.get(valor);
        return question.getQuestion();
    }

    public String[] getAnswer() {
        return question.getAnswer();
    }

    public String getTrueAnswer() {
        return question.getTrueAnswer();
    }

    public void setName(String name) {
        // TODO implement here
    }

    public String getName() {
        // TODO implement here
        return "";
    }

    public String[] getHighScores() {
        // TODO implement here
        return null;
    }
    
    public int getScore(){
    	
		return 0;
    }

    public boolean compare(String quest) {
        // TODO implement here
        return true;
    }

    public void setTime(int time) {
        // TODO implement here
    }

    public void increaseTime() {
        // TODO implement here
    }

    public void decreaseTime() {
        // TODO implement here
    }

    public void registerObserver(BeatObserver o) {
        // TODO implement here
    }

    public void removeObserver(BeatObserver o) {
        // TODO implement here
    }

    public void registerObserver(BPMObserver o) {
        // TODO implement here
    }

    public void removeObserver(BPMObserver o) {
        // TODO implement here
    }

    public void registerObserver(QuestionObserver o) {
        // TODO implement here
    }

    public void removeObserver(QuestionObserver o) {
        // TODO implement here
    }
}