    package main.java;
    import java.util.*;

    public class QuestionModel implements QuestionModelInterface {

    	private String player;
        private int questionDataBaseSize,numberQuestion,time;
    	private ArrayList<Question> questions;
        private HashMap<String,Integer> highScore;
        private Question question;
    	ArrayList beatObservers = new ArrayList();
    	ArrayList bpmObservers = new ArrayList();
    	ArrayList questionObservers= new ArrayList();
    	public QuestionModel() {
        }
        
        private void load(){
        //cargar la base de datos
            
        }
        
        private void save(){
            //hace falta?

        }

        public void initialize() {
            load();
        }

        public String getQuestion() {
            question=questions.get(numberQuestion);
            numberQuestion++;
            return question.getQuestion();  
        }
        public  void addQuestion(Question quest){

        questions.add(questionDataBaseSize,quest);
            questionDataBaseSize++;
        }   

        public String[] getAnswer() {
            // TODO implement here
            return question.getAnswer();
           
        }

        public String getTrueAnswer() {
            // TODO implement here
            return question.getTrueAnswer();
        }

        public void setName(String name) {
        this.player=player;
        }

        public String getName() {
            // TODO implement here
            return player;
        }
        
        public String[] getScore() {
            // TODO implement here
        	//porque un string 
            return null;
        }
        public HashMap getHighScore() {
            // TODO implement here
        	
            return highScore;
        }

        public boolean compare(String quest) {
            // TODO implement here
        	if(quest.equals(question.getTrueAnswer()))
            return true;
        	return false;
        }

        public void setTime(int time) {
            // TODO implement here
        	this.time=time;
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