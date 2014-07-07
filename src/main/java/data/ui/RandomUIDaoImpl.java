package data.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.init.RandomData;

/**
 * 抽奖器运行主界面，各按键功能待完善。
 * @author 唐东宇
 *
 */
public class RandomUIDaoImpl {
	private static JFrame jFrame;// 主面板
	
	private static JMenuBar menuBar;
	private static JMenu fileMenu;
	private static JMenuItem fileSet;//设置参数
	private static JMenuItem fileResult;//显示结果
	private static JMenuItem fileLoad;//载入名单
	private static JMenuItem fileExit;//关闭
	
	//private static JPanel firstPanel;// 上方
	private static JPanel secondPanel;// 中间 
	private static JPanel thirdPanel;// 下方 
	private static JTextField resultField;// 结果显示
	private static JButton startButton;// 开始按钮
	
	// 1.12获取随机数的类
	private static RandomData randomData=null; 
	
	/**
	 *  1.12标识，该标识用于为boolean类型，用于判断继续循环标识
	 */
	@SuppressWarnings("unused")
	private boolean contin;

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		       public void run() {
		    	  createUI();
		       }
		    });
		dataInit();

	}
    //1
	public static void createUI() {
		// 主层
		jFrame = new JFrame("EMS抽奖器");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(jFrame.getContentPane());

		//设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(600, 600));
		jFrame.setLocation(400, 100);
		jFrame.pack();
		jFrame.setVisible(true);

	}
	//2
	public static void dataInit(){
		randomData=RandomData.getInstance();
		randomData.runRandom(2,resultField);
	}
    //1.1
	public static void addComponentsToPane(Container pane) {
		
		// 面板
		
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(550, 400));
		thirdPanel.setPreferredSize(new Dimension(550, 100));
		pane.add(secondPanel,BorderLayout.CENTER);
		pane.add(thirdPanel,BorderLayout.PAGE_END);
		
		//菜单
		menuBar=new JMenuBar();
		fileMenu=new JMenu("文件");
		fileSet=new JMenuItem("设置");
		fileResult=new JMenuItem("结果");
		fileLoad=new JMenuItem("载入");
		fileExit=new JMenuItem("退出");
		fileMenu.add(fileSet);
		fileMenu.add(fileResult);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
		menuBar.add(fileMenu);
		pane.add(menuBar,BorderLayout.PAGE_START);

		// 显示
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setPreferredSize(new Dimension(400, 100));
		
		secondPanel.add(resultField);
		

		// 按钮
		startButton = new JButton();// 开始按键
		startButton.setText("点击开始");
		startButton.setPreferredSize(new Dimension(100, 50));
		thirdPanel.add(startButton);
		//点击按钮，运行RandomData类。
		startButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				resultField.setText("大家好！");
				
				
			}
			
		});
		
	}	

}
