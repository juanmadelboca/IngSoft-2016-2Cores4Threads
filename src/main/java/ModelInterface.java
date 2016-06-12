package main.java;


public interface ModelInterface {
	void registerObserver(BPMObserver o);
	void registerObserver(BeatObserver o);
	
	void removeObserver(BPMObserver o);
	void removeObserver(BeatObserver o);

}
