package main.java;

public interface HeartModelInterface  {
	int getHeartRate();
	
	int getInstancesNumber();

	void registerObserver(InstancesObserver o);

	void removeObserver(InstancesObserver o);

	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void registerObserver(BPMObserver o);

	void removeObserver(BPMObserver o);
}
