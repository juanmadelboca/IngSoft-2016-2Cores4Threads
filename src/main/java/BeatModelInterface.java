package main.java;
 
public interface BeatModelInterface {
	void initialize();
  
	void on();
  
	void off();
  
    void setBPM(int bpm);
  
	int getBPM();
	
	void registerObserver(BPMObserver o);

	void registerObserver(BeatObserver o);
	
	void removeObserver(BPMObserver o);
	
	void removeObserver(BeatObserver o);

}
