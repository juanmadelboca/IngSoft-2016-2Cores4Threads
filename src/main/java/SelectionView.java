package main.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class SelectionView extends DJView{

	JComboBox<String> comboBox;
    BeatModelInterface BModel,QAdapter,HAdapter;
    QuestionModelInterface QModel;
    HeartModelInterface HModel;
    HeartView HView;
    QuestionView QView;
    DJView BView;
	public SelectionView(ControllerInterface controller,BeatModelInterface model) {
		super(controller, model);
	 	this.model = model;
    	if(model instanceof BeatModel){
    		BModel = model;
    	}
    	else if(model instanceof HeartAdapter){
    		HAdapter = model;
    		HModel = ((HeartAdapter)HAdapter).getModel();
    	}
    	else if(model instanceof QuestionAdapter){
    		QAdapter = model;
    		QModel = ((QuestionAdapter)QAdapter).getModel();
    	}
    		
    	this.controller = controller;
   
	}
    
    public void createView() {
    	super.createView();
        comboBox = new JComboBox<String>(new String[] { "QuestionModel", "HeartModel","BeatModel"});
		comboBox.addActionListener(this);
		bpmPanel.add(comboBox, BorderLayout.CENTER);
		viewFrame.setSize(150, 80);
	}
    
    public void createControls(){
    	super.createControls();
    	if(this.model == BModel)
    		comboBox.setSelectedIndex(0);
    	else if(this.model == HAdapter)
    		comboBox.setSelectedIndex(1);
    	else if(this.model == QAdapter)
    		comboBox.setSelectedIndex(2);
    }
  
    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			try{
				int bpm = Integer.parseInt(bpmTextField.getText());
	        	controller.setBPM(bpm);
			}catch(NumberFormatException e){}
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
		else if(event.getSource() == comboBox ){
			if(comboBox.getSelectedIndex() == 0){
				setModelQuestion();
			    setControllerQuestion();
				QModel = new QuestionModel();
			    controller= new QuestionController(QModel);

			      
			}
			else if(comboBox.getSelectedIndex() == 1)
			{
			      setModelHeart();
			      setControllerHeart();
			      controller = new HeartController(HModel);
			}
			else if(comboBox.getSelectedIndex() == 2)
			{
			      setModelBeat();
				  setControllerBeat();
			      BModel.on();
			}
		}
    }

	public void updateBPM() {
		if (model != null) {
			int bpm = ((BeatModelInterface)(model)).getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("offline");
				}
			} else {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Current BPM: " + bpm);
				}
			}
		}
	}
  
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}
	public void setModelQuestion()
	{
		try{
			QModel.equals(QModel);
		}catch(NullPointerException e){
			QModel = new QuestionModel();
			QAdapter = new QuestionAdapter(QModel);
		    QModel.Stop();
		}finally{
			QModel.registerObserver((BeatObserver)this);
			QModel.registerObserver((BPMObserver)this);
			model = QAdapter;
		}
		try{
			BModel.equals(BModel);
			BModel.removeObserver((BeatObserver)this);
			BModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			HModel.equals(HModel);
			HModel.removeObserver((BeatObserver)this);
			HModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();
	}
	
	public void setModelHeart(){
		try{
			HModel.equals(HModel);
		}catch(NullPointerException e){
			HModel = HeartModel.getInstance();
			HAdapter = new HeartAdapter(HModel);
		}finally{
			HModel.registerObserver((BeatObserver)this);
			HModel.registerObserver((BPMObserver)this);
			model = HAdapter;
			QModel.Stop();
		}
		try{
			BModel.equals(BModel);
			BModel.removeObserver((BeatObserver)this);
			BModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			QModel.equals(QModel);
			QModel.removeObserver((BeatObserver)this);
			QModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();
	}
	
	public void setModelBeat(){
		try{
			BModel.equals(BModel);
		}catch(NullPointerException e){
			BModel = new BeatModel();
			BModel.initialize();
			BModel.off();
		}finally{
			BModel.registerObserver((BeatObserver)this);
			BModel.registerObserver((BPMObserver)this);
			model = BModel;
			QModel.Stop();
		}
		try{
			HModel.equals(HModel);
			HModel.removeObserver((BeatObserver)this);
			HModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			QModel.equals(QModel);
			QModel.removeObserver((BeatObserver)this);
			QModel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();
	}
	
	public void setControllerBeat(){
		this.controller = new BeatController(BModel,this);
		if(BModel.getBPM() == 0){
			this.disableStopMenuItem();
			this.enableStartMenuItem();
		}else{
			this.enableStopMenuItem();
			this.disableStartMenuItem();
		}
	}
	
	public void setControllerHeart(){
		this.controller = new HeartController(HModel,this);
	}
	
	public void setControllerQuestion(){
		this.controller = new QuestionController(QModel, this);
		if( QAdapter.getBPM() == 0){
			this.disableStopMenuItem();
			this.enableStartMenuItem();
		}else{
			this.enableStopMenuItem();
			this.disableStartMenuItem();
		}
	}
	
}
