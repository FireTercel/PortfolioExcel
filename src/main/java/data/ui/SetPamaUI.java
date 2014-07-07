package data.ui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * 该类用于设置抽奖器参数，如获奖名额等。
 * @author Administrator
 *
 */
public class SetPamaUI {

	private static JFrame jFrame;// 主面板

	public static void createUI() { 
		// 主层
		jFrame = new JFrame("EMS抽奖器");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(jFrame.getContentPane());
		
		//设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(400, 400));
		jFrame.setLocation(400, 100); 
		jFrame.pack(); 
		jFrame.setVisible(true);

	}
	 
	public static void addComponentsToPane(Container pane) {
		
	}

}
