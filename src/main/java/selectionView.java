package main.java;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;


public class selectionView extends DJView {
    JComboBox<String> combobox;
    BeatModelInterface Bmodel,HAdapter,QAdapter;
    QuestionModelInterface Qmodel;
    HeartModelInterface Hmodel;
	public selectionView(ControllerInterface controller,BeatModelInterface model) 
	{
		super(controller, model);
		// TODO Auto-generated constructor stub
		this.model = model;
		this.controller = controller;
		if(model instanceof BeatModel){
			model = Bmodel;
		}
		else if(model instanceof QuestionAdapter){
			QAdapter = model;
			Qmodel = ((QuestionAdapter)QAdapter).getModel();
		}
		else if(model instanceof HeartAdapter){
			HAdapter = model;
			Hmodel = ((HeartAdapter)HAdapter).getModel();
		}
	}
	public void createView()
	{
		super.createView();
		combobox = new JComboBox<String>(new String[]{"Beat Model","Heart Model","Question Model"});
		combobox.addActionListener(this);
		bpmPanel.add(combobox, BorderLayout.CENTER);
		viewFrame.setSize(200,130);
	}
	public void createControls() 
	{
		super.createControls();
		if (this.model == Bmodel){
			combobox.setSelectedIndex(0);
		}
		else if(this.model == HAdapter){
			combobox.setSelectedIndex(1);
		}
		else if(this.model == QAdapter){
			combobox.setSelectedIndex(2);
		}
		}
    public void actionPerformed(ActionEvent event) 
    {
		if (event.getSource() == setBPMButton) {
			try{
				int bpm = Integer.parseInt(bpmTextField.getText());
	        	controller.setBPM(bpm);
			}
			catch(NumberFormatException e){}
		} 
		else if (event.getSource() == increaseBPMButton) 
		{
			controller.increaseBPM();
		}
		else if (event.getSource() == decreaseBPMButton) 
		{
			controller.decreaseBPM();
		} else if(event.getSource() == combobox){
			if(combobox.getSelectedIndex()==0){
				setModelBeat();
				setControllerBeat();
			}
			else if(combobox.getSelectedIndex()==1){
				setModelHeart();
				setControllerHeart();
			}
			else if(combobox.getSelectedIndex()==2){
				setModelQuestion();
				setModelControllerQuestion();
			}
		}
    }
    
    public void setModelQuestion(){
    	try{
			Qmodel.equals(Qmodel);
		}catch(NullPointerException e){
			Qmodel = new QuestionModel();
			QAdapter = new QuestionAdapter(Qmodel);
		}finally{
			Qmodel.registerObserver((BeatObserver)this);
			Qmodel.registerObserver((BPMObserver)this);
			model = QAdapter;
		}
		try{
			Bmodel.equals(Bmodel);
			Bmodel.removeObserver((BeatObserver)this);
			Bmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			Hmodel.equals(Hmodel);
			Hmodel.removeObserver((BeatObserver)this);
			Hmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();	
    }
    public void setModelBeat(){
    	try{
			Bmodel.equals(Bmodel);
		}catch(NullPointerException e){
			Bmodel = new BeatModel();
			Bmodel.initialize();
			Bmodel.off();
		}finally{
			Bmodel.registerObserver((BeatObserver)this);
			Bmodel.registerObserver((BPMObserver)this);
			model = Bmodel;
		}
		try{
			Hmodel.equals(Hmodel);
			Hmodel.removeObserver((BeatObserver)this);
			Hmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			Qmodel.equals(Qmodel);
			Qmodel.removeObserver((BeatObserver)this);
			Qmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();
    }
    public void setModelHeart()
    {
     	try{
			Hmodel.equals(Hmodel);
		}catch(NullPointerException e){
			Hmodel = HeartModel.getInstance();
			HAdapter = new HeartAdapter(Hmodel);
		}finally{
			Hmodel.registerObserver((BeatObserver)this);
			Hmodel.registerObserver((BPMObserver)this);
			model = HAdapter;
		}
		try{
			Bmodel.equals(Bmodel);
			Bmodel.removeObserver((BeatObserver)this);
			Bmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		try{
			Qmodel.equals(Qmodel);
			Qmodel.removeObserver((BeatObserver)this);
			Qmodel.removeObserver((BPMObserver)this);
		}catch(NullPointerException e){}
		updateBPM();	
    
    }
    public void updateBPM() {
		if (model != null) {
			int bpm = ((BeatModelInterface)model).getBPM();
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
    public void setControllerBeat()
    {
    	controller = new BeatController(Bmodel,this);
    	if (Bmodel.getBPM() ==0 )
        {
            this.disableStopMenuItem();
    		this.enableStartMenuItem();
        }
        else
        {
        	this.disableStartMenuItem();
        	this.enableStopMenuItem();
        }
    }
    public void setControllerHeart()
    {
    	controller = new HeartController(Hmodel,this);
    }
    public void setModelControllerQuestion(){
    	controller = new QuestionController(Qmodel,this);
        if (QAdapter.getBPM() ==0 )
        {
            this.disableStopMenuItem();
    		this.enableStartMenuItem();
        }
        else
        {
        	this.disableStartMenuItem();
        	this.enableStopMenuItem();
        }
    }
	}
		
	
	


