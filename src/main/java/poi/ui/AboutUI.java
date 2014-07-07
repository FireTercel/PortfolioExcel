package poi.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutUI {

	private static JFrame jFrame;
	private static JLabel jlabel;
	private static JFileChooser fc;

	private static GridBagConstraints gridbagArea;
	private static GridBagConstraints gridbagC;

	public static void createUI() {
		// 主层
		jFrame = new JFrame("关于");
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addComponentsToPane(jFrame.getContentPane());

		// 设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(400, 200));
		jFrame.setLocation(450, 150);
		jFrame.pack();
		jFrame.setVisible(true);

	}

	public static void addComponentsToPane(Container pane) {
		jlabel = new JLabel("版权所有 翻版必究        版本：1.2.1v", JLabel.CENTER);
		pane.add(jlabel);

		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}