package data.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RandomUI {
	private Frame frame;
	private TextArea tArea;
	private TextField resultField;
	private Button startButton;
	
	public static void main(String[] args){
		RandomUI rUI=new RandomUI(); 
		rUI.createUI();
	}
	
	
	public void createUI(){
		frame=new Frame("123");
		tArea=new TextArea();
		tArea.setEditable(false); 
		resultField=new TextField(); 
		startButton=new Button("点击开始");
		Panel panel=new Panel();
		panel.setLayout(new BorderLayout());
		panel.add(resultField,"Center"); 
		panel.add(startButton,"South");
		frame.add(panel,"Center");
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				RandomUI.this.shutDown();
			}
		});
		
		frame.setSize(600,600);
		frame.setLocation(400,100);
		frame.setVisible(true);
		resultField.requestFocus();
	}
	
	public void shutDown(){
		System.exit(0);
	}
	
	

}
