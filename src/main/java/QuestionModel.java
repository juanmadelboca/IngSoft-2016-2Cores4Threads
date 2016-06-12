package main.java;

import java.io.*;
import java.util.*;

public class QuestionModel implements QuestionModelInterface {

	private String player;
	private ArrayList<Question> questions;
	private HashMap<String, Integer> highScores;
	private Question question;
	private int time, score;
	private ArrayList<BeatObserver> beatObservers;
	private ArrayList<BPMObserver> bpmObservers;
	private ArrayList<QuestionObserver> questionObservers;
	

	public QuestionModel() {
		questions = new ArrayList<Question>();
		highScores = new HashMap<String, Integer>();
		beatObservers = new ArrayList<BeatObserver>();
		bpmObservers = new ArrayList<BPMObserver>();
		questionObservers = new ArrayList<QuestionObserver>();
	}

	private void load() {
		boolean carga = true;
		ObjectInputStream entrada = null;
		try {
			entrada = new ObjectInputStream(new FileInputStream("base.obj"));
		} catch (IOException e) {
			System.out.println("No existe la base");
			e.printStackTrace();
			carga = false;
		}
		try {
			questions = (ArrayList<Question>) entrada.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No existe el objeto en la base");
			e.printStackTrace();
			carga = false;
		}

		try {
			entrada.close();
		} catch (IOException e) {
			System.out.println("No puedo cerrar el objeto");
			e.printStackTrace();
			carga = false;
		}

		if (carga)
			System.out.println("Carga con exito");
	}

	private void save() {
		boolean guardar = true;
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

	public void addQuestion(Question quest) {
		questions.add(quest);
		save();

	}

	public void initialize() {
		load();
	}
	public void nextQuestion(){
		Random rnd = new Random();
		int valor = (int) (rnd.nextDouble() * questions.size());
		question = questions.get(valor);
	}

	public String getQuestion() {
		
		return question.getQuestion();
	}

	public String[] getAnswer() {
		return question.getAnswer();
	}

	public String getTrueAnswer() {
		return question.getTrueAnswer();
	}

	public void setName(String name) {
		this.player = name;
	}

	public String getHighScores() {
		// TODO implement here
		return highScores.toString();
	}

	public int getScore() {

		return score;
	}

	public String getName() {
		// TODO implement here
		return player;
	}

	public boolean compare(String quest) {
		// TODO implement here
		if (quest.equals(question.getTrueAnswer())){
			increaseScore();
			//sumo puntos, en otras versiones, se multiplica por dificultad, o por tiempo que sobro
			return true;
			}
			return false;
			
		}
	public void increaseScore(){
		score=score+100;
	}

	public void setTime(int time) {
		// TODO implement here
		this.time = time;
	}

	public void increaseTime() {
		// TODO implement here
		time++;
	}

	public void decreaseTime() {
		// TODO implement here
		time--;
	}

	public void registerObserver(BeatObserver o) {
		// TODO implement here
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		// TODO implement here
		beatObservers.remove(o);
	}

	public void registerObserver(BPMObserver o) {
		// TODO implement here
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		// TODO implement here
		bpmObservers.remove(o);
	}

	public void registerObserver(QuestionObserver o) {
		// TODO implement here
		questionObservers.add(o);
	}

	public void removeObserver(QuestionObserver o) {
		// TODO implement here
		questionObservers.remove(o);
	}
    }