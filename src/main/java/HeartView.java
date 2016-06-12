package main.java;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HeartView extends DJView implements InstancesObserver{
	HeartModel Hmodel;
	JLabel instancesLabel;
	
	public HeartView(ControllerInterface controller, BeatModelInterface model, HeartModel Hmodel) {
		super(controller, model);
		this.Hmodel = Hmodel;
		Hmodel.registerObserver((InstancesObserver)this);
	}

	public void createView(){
		super.createView();
		instancesLabel = new JLabel("Instancias: "+String.valueOf(Hmodel.getInstancesNumber()),SwingConstants.CENTER);
		bpmPanel.add(instancesLabel);
	}
	public void updateInstances(){
		instancesLabel.setText("Instancias: "+String.valueOf(Hmodel.getInstancesNumber()));
	}

}
