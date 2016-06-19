package main.java;

import java.io.*;
import java.util.*;

public class QuestionModel implements QuestionModelInterface, Runnable {

	private String player;
	private int dificulty;
	private ArrayList<Question> questions;
	private HashMap<String, Integer> highScores;
	private Question question;
	private int time, score;
	private ArrayList<BeatObserver> beatObservers;
	private ArrayList<BPMObserver> bpmObservers;
	private ArrayList<QuestionObserver> questionObservers;
	private Thread thread;
	private boolean start;


	public QuestionModel() {
		questions = new ArrayList<Question>();
		highScores = new HashMap<String, Integer>();
		beatObservers = new ArrayList<BeatObserver>();
		bpmObservers = new ArrayList<BPMObserver>();
		questionObservers = new ArrayList<QuestionObserver>();
		dificulty = 0;
		thread = new Thread(this);
		score=0;
		time=100;
	}

	@SuppressWarnings("unchecked")
	private void load() {
		boolean carga = true;
		try {
			//cargo las preguntas y los highScores
			
			FileInputStream fileIn = new FileInputStream(new File("base.obj"));
			ObjectInputStream entrada = new ObjectInputStream(fileIn);
			questions = (ArrayList<Question>) entrada.readObject();
			entrada.close();
			FileInputStream fileIn2 = new FileInputStream(new File("highScores.obj"));
			ObjectInputStream entrada2 = new ObjectInputStream(fileIn2);
			highScores = (HashMap<String, Integer>) entrada2.readObject();
			entrada2.close();
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("No existe la base o el objeto se procede a crearla");
		}
		 catch (ClassNotFoundException e ) {
			System.out.println("No existe el objeto en la base");
			e.printStackTrace();
			carga = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			carga = false;
		}

		

		if (carga)
			System.out.println("Carga con exito");
	}

	private void saveScore(){

		boolean guardar = true;
		try {
			//guardo preguntas
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("highScores.obj"));
			salida.writeObject(highScores);
			salida.close();}
		catch (FileNotFoundException e) {
			System.out.println("No existe la base o el objeto se procede a crearla");
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			guardar = false;
		}
	}

	private void save() {
		boolean guardar = true;
		try {
			//guardo preguntas
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("base.obj"));
			salida.writeObject(questions);
			salida.close();}
		catch (FileNotFoundException e) {
			System.out.println("No existe la base o el objeto se procede a crearla");
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			guardar = false;
		}
		
	
	}
	public void addQuestion(Question quest) {
		questions.add(quest);
		save();

	}

	public void initialize() {
		load();
		thread.start();
		start=false;
	}

	public void nextQuestion() {
		if(!questions.isEmpty()){
		Random rnd = new Random();
		int valor = (int) (rnd.nextDouble() * questions.size());
		question = questions.get(valor);
		questions.remove(valor);
		notifyQuestionObserver();
		start=true;
		}else
		{
			// ACA TENEMOS QUE AGREGAR QUE DEBE HACER EL PROGRAMA CUANDO SE ACABEN LAS PREGUNTAS
			finishGame();
		}
		}

	private	void finishGame(){
		highScores.put(player, score);
		System.out.println(getHighScores());
		saveScore();
		question=null;
		notifyQuestionObserver();
	}
	public String getQuestion() {
		if(question==null){
			System.out.println("Arranca null");
			return  null;
		}else{
		return question.getQuestion();
		}
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

		Iterator it = highScores.entrySet().iterator();
		StringBuffer sb= new StringBuffer();

		sb.append("Player"+"				"+"| Points"	+"\n");
		sb.append("---------------------------------------------------------------------------------------------------------------"+"\n");
		while (it.hasNext()) {
		Map.Entry e = (Map.Entry)it.next();
		sb.append(e.getKey()+"				"+e.getValue()	+"\n");
		}
		
		return sb.toString();
	}

	public int getScore() {

		return score;
	}

	public String getName() {
		// TODO implement here
		return player;
	}

	public boolean compare(String quest) {
		if (quest.equals(question.getTrueAnswer())) {
			increaseScore();
			return true;
		}
		return false;
	}

	public void increaseScore() {
		score = score + 100;
	}

	public int getTime (){
		return time;
	}
	
	public void setTime(int time) {
		// TODO implement here
		this.time = time;
		notifyBPMObserver();
	}

	public void increaseTime() {
		// TODO implement here
		time++;
		notifyBPMObserver();
	}

	public void decreaseTime() {
		// TODO implement here
		time--;
		notifyBPMObserver();
		notifyBeatObserver();
	}
    public int getDificulty()
	{
		return dificulty;
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
	public void notifyQuestionObserver(){
		int i=0;
		while( i<questionObservers.size()){
			QuestionObserver observer= questionObservers.get(i);
			observer.updateQuestion();
			i++;
		}
	}
	public void notifyBPMObserver(){
		int i=0;
		while( i<bpmObservers.size()){
			BPMObserver observer= bpmObservers.get(i);
			observer.updateBPM();
			i++;
		}
	}
	public void notifyBeatObserver(){
		int i=0;
		while( i<beatObservers.size()){
			BeatObserver observer= beatObservers.get(i);
			observer.updateBeat();
			i++;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(time!=0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (start)
				decreaseTime();
			
			
		
	}
		finishGame();
	//aca el codigo de que hacer cuando se acaba el tiempo
		
}

	@Override
	public void Stop() 
	{
		Thread.interrupted();
		notifyBPMObserver();
	}
}
