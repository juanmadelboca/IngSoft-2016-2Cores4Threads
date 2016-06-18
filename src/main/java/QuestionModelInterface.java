package main.java;


public interface QuestionModelInterface {

	void initialize();

	String getQuestion();

	String[] getAnswer();

	String getTrueAnswer();

	void setName(String name);

	String getName();

	String getHighScores();

	int getScore();
	
	int getTime();

	boolean compare(String quest);

	void addQuestion(Question quest);

	void nextQuestion();

	void setTime(int time);

	void increaseTime();

	void decreaseTime();

	int getDificulty();

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BPMObserver o);

	void removeObserver(BPMObserver o);

	void registerObserver(QuestionObserver o);

	void removeObserver(QuestionObserver o);

	void Stop();

}