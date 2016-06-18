package main.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class SelectionView extends DJView {

	JComboBox<String> comboBox;
	BeatModelInterface BModel;
	QuestionModelInterface QModel;
	HeartModelInterface HModel;
	QuestionController QController;
	HeartController HController;
	BeatController BController;
	HeartAdapter HAdapter;
	QuestionAdapter QAdapter;

	public SelectionView(ControllerInterface controller, BeatModelInterface model) {
		super(controller, model);
		BModel = model;
		QModel = new QuestionModel();
		HModel = HeartModel.getInstance();
		BController = (BeatController) controller;
		HController = new HeartController(HModel);
		QController = new QuestionController(QModel);
		BController.showBeatBar(false);
		HController.showBeatBar(false);
		QController.showBeatBar(false);
		HAdapter= new HeartAdapter(HModel);
		QAdapter= new QuestionAdapter(QModel);
		createView();
		createControls();

	}

	public void createView() {
		super.createView();
		comboBox = new JComboBox<String>(new String[] { "BeatModel", "HeartModel", "QuestionModel" });
		comboBox.addActionListener(this);
		bpmPanel.add(comboBox, BorderLayout.CENTER);
		viewFrame.setSize(150, 80);
	}

	public void createControls() {
		super.createControls();
		controlFrame.setVisible(false);
		if (this.model.equals(BModel))
			comboBox.setSelectedIndex(0);
		else if (this.model.equals((HeartAdapter) HModel))
			comboBox.setSelectedIndex(1);
		else if (this.model.equals((QuestionAdapter) QModel))
			comboBox.setSelectedIndex(2);

	}

	public void actionPerformed(ActionEvent event) {
		if (comboBox.getSelectedIndex() == 0) {
			setControllerBeat();
		} else if (comboBox.getSelectedIndex() == 1) {
			setControllerHeart();
		} else if (comboBox.getSelectedIndex() == 2) {
			setControllerQuestion();
		}
	}

	public void setControllerBeat() {
		controller = BController;
		model.removeObserver((BeatObserver)this);
		model.removeObserver((BPMObserver)this);
		model = BModel;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
		if (BModel.getBPM() == 0) {
			this.disableStopMenuItem();
			this.enableStartMenuItem();
		} else {
			this.enableStopMenuItem();
			this.disableStartMenuItem();
		}
		updateBPM();
	}

	public void setControllerHeart() {
		controller = HController;
		model.removeObserver((BeatObserver)this);
		model.removeObserver((BPMObserver)this);
		model = HAdapter;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
		updateBPM();
	}

	public void setControllerQuestion() {
		controller = QController;
		model.removeObserver((BeatObserver)this);
		model.removeObserver((BPMObserver)this);
		model = QAdapter;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BPMObserver) this);
		this.disableStopMenuItem();
		this.disableStartMenuItem();
		updateBPM();
	}

}
