package main.java;

import java.util.*;


public class HeartModel implements HeartModelInterface, Runnable {
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	static ArrayList<InstancesObserver> InstancesObservers = new ArrayList<InstancesObserver>();
	
	int time = 1000;
    int bpm = 90;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;
	
	static HeartModel heart=null;			//singleton
	static int Instances = 0; 

	private HeartModel() {					//singleton
		thread = new Thread(this);
		thread.start();
		heart = this;
	}
	
	public static HeartModel getInstance(){	//Singleton
		try{
			Instances++;
			heart.equals(heart);
		}catch(NullPointerException e){
			heart = new HeartModel();
		}finally{
			notifyInstancesObservers();
		}
		return heart;
	}
	
	public int getInstancesNumber(){
		return Instances;
	}

	int lastrate = -1;
	public void run() {

		for(;;) {
			int change = random.nextInt(10);
			if (random.nextInt(2) == 0) {
				change = 0 - change;
			}
			int rate = 60000/(time + change);
			if (rate < 120 && rate > 50) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
				}
			}
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	public int getHeartRate() {
		return 60000/time;
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
	
	public void registerObserver(InstancesObserver o){
		InstancesObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}
	
	public void removeObserver(InstancesObserver o) {
		try{
			InstancesObservers.remove(InstancesObservers.indexOf(o));
		}catch(IndexOutOfBoundsException e){};
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
	
	public static void notifyInstancesObservers(){
		for(InstancesObserver o: InstancesObservers){
			o.updateInstances();
		}
	}

}
