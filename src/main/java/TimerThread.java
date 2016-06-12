package main.java;

public class TimerThread implements Runnable {

	private QuestionModel model;
	
	TimerThread(QuestionModel m){
		model=m;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("me rompi");
				e.printStackTrace();
			}
			System.out.println("decremente");
			model.decreaseTime();
			
		}

	}

}
