package main.java;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class QuestionView implements QuestionObserver, BeatObserver, BPMObserver {
	
	private ControllerInterface controller;
	private QuestionModelInterface model;
	private JFrame frmcoresthreads;
	private JTextField txtScore;
	private JTextField textField;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmNuevoJugador;
	private JTextField txtpnTiempoRestante;
	private JTextPane textPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JButton btnNewButton;
	private JButton btnSaltar;
	private JSeparator separator;
	private JDialog emergente;
	private JDialog pregunta;
	private JLabel lblEscribeTuNombre;
	private JButton btnContinuar;
	private JMenuItem mntmNuevaPregunta;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String answer;

    public QuestionView(ControllerInterface controller, QuestionModelInterface model) {
    	this.controller= controller;
    	this.model= model;
    	model.registerObserver((BPMObserver)this);
    	model.registerObserver((BeatObserver)this);
    	model.registerObserver((QuestionObserver)this);
    	createControls();
    }

    private void initialize(){
    	controller.start();
	}
    
    public void updateQuestion() {
        nextQuestion();
    }

    public void updateBPM() {
    	txtpnTiempoRestante.setText("Tiempo restante: " + Integer.toString(model.getTime()));
    	txtpnTiempoRestante.repaint();
    }
    public void updateBeat() {
        // TODO implement here
    }
	
	private void nextQuestion(){
		textPane.setText(model.getQuestion());
		String array[]= model.getAnswer();
		rdbtnNewRadioButton.setText(array[0]);
		rdbtnNewRadioButton_1.setText(array[1]);
		rdbtnNewRadioButton_2.setText(array[2]);
		rdbtnNewRadioButton_3.setText(array[3]);
		rdbtnNewRadioButton.setEnabled(true);
		rdbtnNewRadioButton_1.setEnabled(true);
		rdbtnNewRadioButton_2.setEnabled(true);
		rdbtnNewRadioButton_3.setEnabled(true);
		rdbtnNewRadioButton.setSelected(false);
		rdbtnNewRadioButton_1.setSelected(false);
		rdbtnNewRadioButton_2.setSelected(false);
		rdbtnNewRadioButton_3.setSelected(false);
		rdbtnNewRadioButton.repaint();
		rdbtnNewRadioButton_1.repaint();
		rdbtnNewRadioButton_2.repaint();
		rdbtnNewRadioButton_3.repaint();
		txtpnTiempoRestante.setText("Tiempo restante: " + Integer.toString(model.getTime()));
		txtpnTiempoRestante.setEnabled(true);
		txtScore.setText("Score: "+ Integer.toString(model.getScore()));
		txtScore.repaint();
		textPane.setEnabled(true);
	}
	
	private void createControls() {
		frmcoresthreads = new JFrame();
		frmcoresthreads.setTitle("2Cores4Threads - QuestionView");
		frmcoresthreads.setBounds(100, 100, 480, 315);
		frmcoresthreads.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmcoresthreads.getContentPane().setLayout(null);
		frmcoresthreads.setVisible(true);

		pregunta = new JDialog(frmcoresthreads, "Nueva Pregunta");
		pregunta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pregunta.setBounds(10, 11, 444, 358);
		pregunta.getContentPane().setLayout(null);

		JLabel lblPregunta = new JLabel("Pregunta:");
		lblPregunta.setBounds(10, 11, 63, 14);
		pregunta.getContentPane().add(lblPregunta);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 36, 408, 20);
		pregunta.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblRespuestas = new JLabel("Respuestas:");
		lblRespuestas.setBounds(10, 67, 63, 14);
		pregunta.getContentPane().add(lblRespuestas);

		textField_2 = new JTextField();
		textField_2.setBounds(10, 92, 408, 20);
		pregunta.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 123, 408, 20);
		pregunta.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(10, 154, 408, 20);
		pregunta.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(10, 185, 408, 20);
		pregunta.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta:");
		lblRespuestaCorrecta.setBounds(10, 216, 113, 14);
		pregunta.getContentPane().add(lblRespuestaCorrecta);

		textField_6 = new JTextField();
		textField_6.setBounds(10, 241, 408, 20);
		pregunta.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(165, 289, 97, 29);
		pregunta.getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pregunta.setVisible(false);
				String respuesta[] = new String[4];
				respuesta[0] = textField_2.getText();
				respuesta[1] = textField_3.getText();
				respuesta[2] = textField_4.getText();
				respuesta[3] = textField_5.getText();
				try{
				((QuestionController) controller).addQuestion(textField_1.getText(), respuesta, textField_6.getText());
				}catch(Exception e){
					 JOptionPane.showMessageDialog( null, "Debe ingresar Todos las respuestas y la pregunta" );
					
					
				}
				finally{
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");

			}}
		});

		panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 39, 444, 226);
		frmcoresthreads.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 464, 28);
		frmcoresthreads.getContentPane().add(menuBar);

		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		mntmNuevoJugador = new JMenuItem("Nuevo Jugador");
		mnMenu.add(mntmNuevoJugador);
		mntmNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emergente.setVisible(true);
			}
		});

		mntmNuevaPregunta = new JMenuItem("Nueva Pregunta");
		mnMenu.add(mntmNuevaPregunta);
		mntmNuevaPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pregunta.setVisible(true);
			}
		});

		txtpnTiempoRestante = new JTextField();
		txtpnTiempoRestante.setBounds(155, 11, 134, 20);
		panel_1.add(txtpnTiempoRestante);
		txtpnTiempoRestante.setBackground(SystemColor.menu);
		txtpnTiempoRestante.setForeground(Color.BLACK);
		txtpnTiempoRestante.setText("Tiempo Restante: ");
		txtpnTiempoRestante.setEditable(false);
		textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setBackground(SystemColor.inactiveCaptionBorder);
		textPane.setBounds(30, 32, 383, 23);
		panel_1.add(textPane);
		textPane.setEditable(false);

		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(21, 62, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnNewRadioButton_2.setEnabled(false);
					rdbtnNewRadioButton_3.setEnabled(false);
					answer = rdbtnNewRadioButton.getText();
				} else {
					rdbtnNewRadioButton_1.setEnabled(true);
					rdbtnNewRadioButton_2.setEnabled(true);
					rdbtnNewRadioButton_3.setEnabled(true);
				}

			}
		});

		rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setBounds(21, 88, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnNewRadioButton_2.setEnabled(false);
					rdbtnNewRadioButton_3.setEnabled(false);
					answer = rdbtnNewRadioButton_1.getText();
				} else {
					rdbtnNewRadioButton.setEnabled(true);
					rdbtnNewRadioButton_2.setEnabled(true);
					rdbtnNewRadioButton_3.setEnabled(true);
				}

			}
		});

		rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(21, 114, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton_2.isSelected()) {
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnNewRadioButton_1.setEnabled(false);
					rdbtnNewRadioButton_3.setEnabled(false);
					answer = rdbtnNewRadioButton_2.getText();
				} else {
					rdbtnNewRadioButton.setEnabled(true);
					rdbtnNewRadioButton_1.setEnabled(true);
					rdbtnNewRadioButton_3.setEnabled(true);
				}

			}
		});

		rdbtnNewRadioButton_3 = new JRadioButton("");
		rdbtnNewRadioButton_3.setBounds(21, 140, 109, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton_3.isSelected()) {
					rdbtnNewRadioButton.setEnabled(false);
					rdbtnNewRadioButton_2.setEnabled(false);
					rdbtnNewRadioButton_1.setEnabled(false);
					answer = rdbtnNewRadioButton_3.getText();
				} else {
					rdbtnNewRadioButton.setEnabled(true);
					rdbtnNewRadioButton_2.setEnabled(true);
					rdbtnNewRadioButton_1.setEnabled(true);
				}

			}
		});

		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(10, 192, 89, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((QuestionController) controller).send(answer);
			}
		});

		txtScore = new JTextField();
		txtScore.setBounds(165, 192, 113, 23);
		panel_1.add(txtScore);
		txtScore.setText("Score:");
		txtScore.setEditable(false);
		txtScore.setColumns(10);

		btnSaltar = new JButton("Saltar");
		btnSaltar.setBounds(345, 192, 89, 23);
		panel_1.add(btnSaltar);
		btnSaltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((QuestionController) controller).skip();
			}
		});

		separator = new JSeparator();
		separator.setBounds(0, 173, 444, 10);
		panel_1.add(separator);

		emergente = new JDialog(frmcoresthreads, "Nuevo Jugador");
		emergente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		emergente.setBounds(10, 11, 444, 254);
		emergente.getContentPane().setLayout(null);

		lblEscribeTuNombre = new JLabel("Escribe tu Nombre");
		lblEscribeTuNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEscribeTuNombre.setBounds(141, 11, 145, 19);
		emergente.getContentPane().add(lblEscribeTuNombre);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(47, 83, 333, 33);
		emergente.getContentPane().add(textField);
		textField.setColumns(10);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(151, 162, 125, 33);
		emergente.getContentPane().add(btnContinuar);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emergente.setVisible(false);
				panel_1.setVisible(true);
				((QuestionController) controller).setName(textField.getText());
				initialize();
			}
		});
	}



}