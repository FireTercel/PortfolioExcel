package poi.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import poi.action.ExcelAction;

/**
 * 
 * @author 唐东宇
 *
 */
public class DealExcelUI {
	private static JFrame jFrame;
 
	private static JMenuBar menuBar;// 菜单栏
	private static JMenu fileMenu;// 主控件
	private static JMenuItem fileSet;// 设置参数
	private static JMenuItem fileResult;// 显示结果
	private static JMenuItem fileLoad;// 载入名单
	private static JMenuItem fileExit;// 关闭
	
	private static JMenu configure;//工具
	private static JMenuItem printPrivoder;
	private static JMenuItem printPostroad;
	
	private static JMenu aboutM;//关于
	private static JMenuItem about;

	private static JPanel secondPanel;// 中间
	private static JPanel textPanel;
	private static JPanel thirdPanel;// 下方
	private static JTextField resultField;// 结果显示
	private static JTextField startTime;//开始时间
	private static JTextField endTime;//结束时间
	private static JLabel startLabel;//开始标签
	private static JLabel endLabel;//结束标签
	private static JTextArea resultArea;//显示框
	private static JScrollPane jscrollPane;//滚动条
	private static JButton startButton;// 业务开始按钮
	private static JButton middleButton;//业务处理按钮
	private static JButton xinxiButton;//信息台报表生成
	private static JButton endButton;//业务结束按钮
	
	private static JFileChooser fc;//选择文件夹控件。
	private static JButton selectFile;//选择文件夹按钮。
	private static JLabel selectFileLebel;//显示路径面板。
	private static String filesUrl;//存放文件夹路径。
	
	private static GridBagConstraints gridbagArea;
	private static GridBagConstraints gridbagC;
	
	private ExcelAction excelAction;

	public static void main(String[] args) {
		
		objectInit();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createUI();
			}
		});

	}
	
	public static void objectInit(){
		DealExcelUI dealExcelUI=new DealExcelUI();
		dealExcelUI.excelAction=new ExcelAction();
	}

	public static void createUI() {
		jFrame = new JFrame("业务动态监控");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPane(jFrame.getContentPane());

		// 设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(600, 700));
		jFrame.setLocation(400, 100);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	/**
	 * 获得文件夹路径方法
	 * @return 文件夹路径
	 */
	public static String chooseFile(){
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 只能选择目录
		filesUrl= "";
		File f = null;
		int flag = 0;
		try {
			flag = fc.showOpenDialog(null);
		} catch (HeadlessException head) {
			System.out.println("Open File Dialog ERROR!");
		}
		if (flag == JFileChooser.APPROVE_OPTION) {
			// 获得该文件
			f = fc.getSelectedFile();
			filesUrl = f.getPath();
		}

		// 以上获得选择的文件夹
		// 若要判断其中是否还有其他目录，可以这样做
		boolean hasSubDir = false;
		File dir = new File(filesUrl);
		// 获得改目录下的文件的文件名，如果没有的话，filesName.length()=0
		String[] filesName = dir.list();
		for (int i = 0; i < filesName.length; i++) {
			File temp = new File(filesUrl + "/" + filesName[i]);
			if (temp.isDirectory()) {
				hasSubDir = true;
				break;
			}

		}
		System.out.println(filesUrl);
		return filesUrl;
	}

	public static void addComponentsToPane(Container pane) {
		// 面板

		secondPanel = new JPanel();
		textPanel=new JPanel();
		thirdPanel = new JPanel();
		secondPanel.setPreferredSize(new Dimension(550, 300));
		textPanel.setPreferredSize(new Dimension(540, 100));
		textPanel.setLayout(new FlowLayout());
		thirdPanel.setPreferredSize(new Dimension(550, 200));
		pane.add(secondPanel, BorderLayout.CENTER);
		//pane.add(textPanel, BorderLayout.CENTER);
		pane.add(thirdPanel, BorderLayout.PAGE_END);

		// 菜单
		menuBar = new JMenuBar();
		fileMenu = new JMenu("文件");
		fileSet = new JMenuItem("设置");
		fileResult = new JMenuItem("结果");
		fileLoad = new JMenuItem("载入");
		fileExit = new JMenuItem("退出", KeyEvent.VK_E);
		fileMenu.add(fileSet);
		fileMenu.add(fileResult);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
		menuBar.add(fileMenu);
		
		fileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				System.exit(0);
			}
		});
		
		//关于
		configure=new JMenu("工具");
		printPrivoder=new JMenuItem("省份");
		printPostroad=new JMenuItem("省际出口流量");
		configure.add(printPrivoder);
		configure.add(printPostroad);
		menuBar.add(configure);
		
		
		aboutM=new JMenu("帮助");
		about=new JMenuItem("关于...");
		aboutM.add(about);
		menuBar.add(aboutM);
		
		pane.add(menuBar, BorderLayout.PAGE_START);

		// 显示
		/*resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setPreferredSize(new Dimension(400, 100));

		secondPanel.add(resultField);*/
		
	    gridbagArea= new GridBagConstraints();
	    gridbagC = new GridBagConstraints();
		
		resultArea=new JTextArea("记录面板");
		resultArea.setEditable(true);
		resultArea.setPreferredSize(new Dimension(500,350));
		
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
		
		secondPanel.add(jscrollPane,gridbagArea);
		
		startTime=new JTextField();
		endTime=new JTextField();
		
		startTime.setPreferredSize(new Dimension(150,30));
		endTime.setPreferredSize(new Dimension(150,30));
		
		startLabel=new JLabel();
		startLabel.setText("开始时间：");
		
		endLabel=new JLabel();
		endLabel.setText("结束时间：");
		
		textPanel.add(startLabel);
		textPanel.add(startTime);
		textPanel.add(endLabel);
		textPanel.add(endTime);
		
		secondPanel.add(textPanel);
		
		selectFileLebel=new JLabel();
		selectFileLebel.setPreferredSize(new Dimension(400, 50));

		// 按钮
		//选择文件夹。
		selectFile=new JButton();
		selectFile.setText("选择文件夹");
		selectFile.setPreferredSize(new Dimension(100, 50));
		thirdPanel.add(selectFile);
		thirdPanel.add(selectFileLebel);
		selectFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				chooseFile();
				selectFileLebel.setText(filesUrl);
			}
		});
		
		//省际进口业务量统计——广东省详细路向
		middleButton=new JButton();
		middleButton.setText("省际邮路监控");
		middleButton.setPreferredSize(new Dimension(130, 50));
		thirdPanel.add(middleButton);
		middleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ExcelAction excelAction=new ExcelAction();
				String start=startTime.getText();
				String end=endTime.getText();
				//excelAction.postroadsForResults(start,end);
				String conn="SJ";
				excelAction.newPostroadsForResults(start,end,conn,filesUrl);
				String message=resultArea.getText()+"\n"+"省际邮路监控报表生成成功！文件名：省际邮路监控.xls";
				resultArea.setText(message); 
			}
		});
		
		//省际进口业务量统计
		xinxiButton=new JButton();
		xinxiButton.setText("进口报表");
		xinxiButton.setPreferredSize(new Dimension(120, 50));
		thirdPanel.add(xinxiButton);
		xinxiButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ExcelAction excelAction=new ExcelAction(); 
				String start=startTime.getText();
				String end=endTime.getText();
				//excelAction.postroadsForResults(start,end);
				String conn="GD";
				excelAction.newPostroadsForResults(start,end,conn,filesUrl);
				String message=resultArea.getText()+"\n"+"进口邮路汇总报表生成成功！文件名：进口邮路汇总.xls";
				resultArea.setText(message);
			}
		});
		
		//Excel合并功能。
		startButton = new JButton();// 开始按键
		startButton.setText("合并报表");
		startButton.setPreferredSize(new Dimension(120, 50));
		thirdPanel.add(startButton);
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ExcelAction excelAction=new ExcelAction();
				String start=startTime.getText();
				String end=endTime.getText();
				excelAction.allExcelFileForResult(start,end,filesUrl);
				String message=resultArea.getText()+"\n"+"合并报表生成成功！文件名：合并报表汇总文件.xls";
				resultArea.setText(message);
			}
		});
		
		//机构代码装换为中文。
		endButton=new JButton();
		endButton.setText("平衡合拢转换");
		endButton.setPreferredSize(new Dimension(120, 50));
		thirdPanel.add(endButton);
		endButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ExcelAction excelAction=new ExcelAction();
				excelAction.changePackFormatForResult();
				String message=resultArea.getText()+"\n"+"平衡合拢结果报表生成成功！文件名：平衡合拢转换结果.xls";
				resultArea.setText(message);
			}
		});
		
		
		//
		/*printPrivoder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InstrumentUI instrumentUI=new InstrumentUI();
				instrumentUI.createUI();
			}
		});*/
		
		printPostroad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PostroadUI postroadUI=new PostroadUI();
				postroadUI.createUI();
			}
		});
		
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AboutUI aboutUI=new AboutUI();
				aboutUI.createUI();
			}
		});

	}

}
