package main.java;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HeartView extends DJView implements InstancesObserver{
	JLabel instancesLabel;
	
	public HeartView(ControllerInterface controller, BeatModelInterface model) {
		super(controller, model);
		((HeartAdapter) model).registerObserver((InstancesObserver)this);
	}

	public void createView(){
		super.createView();
		instancesLabel = new JLabel("Instancias: "+String.valueOf(((HeartAdapter) model).getInstancesNumber()),SwingConstants.CENTER);
		bpmPanel.add(instancesLabel);
	}
	public void updateInstances(){
		instancesLabel.setText("Instancias: "+String.valueOf(((HeartAdapter) model).getInstancesNumber()));
	}

}
