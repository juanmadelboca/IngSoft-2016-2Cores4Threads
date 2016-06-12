package main.java;
 
public interface BeatModelInterface extends ModelInterface {
	void initialize();
  
	void on();
  
	void off();
  
    void setBPM(int bpm);
  
	int getBPM();
}
