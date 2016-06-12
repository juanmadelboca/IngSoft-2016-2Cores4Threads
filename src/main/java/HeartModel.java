package main.java;

import java.util.ArrayList;
import java.util.Random;

public class HeartModel implements HeartModelInterface, Runnable {
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	static ArrayList<InstancesObserver> InstancesObservers = new ArrayList<InstancesObserver>();
	int time = 1000;
	int bpm = 90;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;
	static HeartModel corazon=null;			//singleton
	static int Instancias = 0;

	HeartModel() {					//constructor privado
		thread = new Thread(this);
		thread.start();
		corazon = this;
	}
	public static HeartModel getInstance(){	//devuelvo el modelo cuando necesite llamar al unico objeto creado y notifico a los observers
		try{
			Instancias++;
			corazon.equals(corazon);
		}catch(NullPointerException e){
			corazon = new HeartModel();
		}finally{
			notifyInstancesObservers();
		}
		return corazon;
	}
	public int getInstancesNumber() //devuelvo cantidad de veces que se llama al singleton
	{
		return Instancias;
	}


	public void run() {
		int lastrate = -1;

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

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
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
	public void removeObsever(InstancesObserver o){
		try{
			InstancesObservers.remove(InstancesObservers.indexOf(o));
		}catch(IndexOutOfBoundsException e){};
	}
	public void registerObserver(InstancesObserver o){
		InstancesObservers.add(o);
	}

}
