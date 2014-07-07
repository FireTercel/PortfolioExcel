package poi.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstrumentUI {
	
	private static JFrame jFrame;
	
	private static JButton providerButton;
	private static JButton postroadButton;
	private static JTextArea resultArea;//显示框
	private static JScrollPane jscrollPane;//滚动条 
	
	private static GridBagConstraints gridbagArea;
	private static GridBagConstraints gridbagC;
	 
	public static void createUI() { 
		// 主层 
		jFrame = new JFrame("工具");
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addComponentsToPane(jFrame.getContentPane()); 
		
		//设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(400, 400));
		jFrame.setLocation(450, 150);
		jFrame.pack();
		jFrame.setVisible(true);
 
	}
	 
	public static void addComponentsToPane(Container pane) {
		JButton button;
	    pane.setLayout(new GridBagLayout());
	    
	    gridbagArea= new GridBagConstraints();
	    gridbagC = new GridBagConstraints();
	    
	    resultArea=new JTextArea("记录面板");
	    resultArea.setEditable(true);
		//resultArea.setPreferredSize(new Dimension(100,100));
		
		jscrollPane=new JScrollPane(resultArea);
		jscrollPane.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		jscrollPane.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		gridbagArea.fill = GridBagConstraints.HORIZONTAL;
		gridbagArea.ipady = 140;
		gridbagArea.ipadx=300;
		gridbagArea.gridx = 0;
		gridbagArea.gridy = 0;
		pane.add(jscrollPane, gridbagArea);
	 
	    providerButton = new JButton("省际报表");
	    gridbagC.fill = GridBagConstraints.HORIZONTAL;
	    gridbagC.gridx = 0;
	    gridbagC.gridy = 1;
	    pane.add(providerButton, gridbagC);
	 
	    postroadButton = new JButton("省内报表");
	    gridbagC.fill = GridBagConstraints.HORIZONTAL;
	    gridbagC.gridx = 1;
	    gridbagC.gridy = 1;
	    pane.add(postroadButton, gridbagC);

	 
	    button = new JButton("5");
	    gridbagC.fill = GridBagConstraints.HORIZONTAL;
	    gridbagC.ipady = 0; // reset to default
	    gridbagC.weighty = 1.0; // request any extra vertical space
	    gridbagC.anchor = GridBagConstraints.PAGE_END; // bottom of space
	    gridbagC.insets = new Insets(10, 0, 0, 0); // top padding
	    gridbagC.gridx = 1; // aligned with button 2
	    gridbagC.gridwidth = 2; // 2 columns wide
	    gridbagC.gridy = 2; // third row
	    pane.add(button, gridbagC);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
