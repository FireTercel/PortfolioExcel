package poi.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import poi.action.FullProcessAction;

public class FullProcessUI{

	private static JFrame jFrame;

	private static JButton providerButton;
	private static JButton postroadButton;
	private static JTextArea resultArea;// 显示框
	private static JScrollPane jscrollPane;// 滚动条

	private static JFileChooser fc;// 选择文件夹控件。
	private static JButton selectFile;// 选择文件夹按钮。
	private static JLabel selectFileLebel;// 显示路径面板。
	private static String filesUrl;// 存放文件夹路径。

	private static GridBagConstraints gridbagArea;
	private static GridBagConstraints gridbagC;
	
	public static void createUI() {
		// 主层
		jFrame = new JFrame("全程跟踪");
		jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addComponentsToPane(jFrame.getContentPane());

		// 设置空间大小SIZE
		jFrame.setPreferredSize(new Dimension(400, 400));
		jFrame.setLocation(450, 150);
		jFrame.pack();
		jFrame.setVisible(true);

	}

	/**
	 * 获得文件夹路径方法
	 * 
	 * @return 文件夹路径
	 */
	public static String chooseFile() {

		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 只能选择目录
		filesUrl = "";
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

		pane.setLayout(new GridBagLayout());

		gridbagArea = new GridBagConstraints();
		gridbagC = new GridBagConstraints();

		resultArea = new JTextArea("记录面板");
		resultArea.setEditable(true);
		// resultArea.setPreferredSize(new Dimension(100,100));

		jscrollPane = new JScrollPane(resultArea);
		jscrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		gridbagArea.fill = GridBagConstraints.HORIZONTAL;
		gridbagArea.ipady = 140;
		gridbagArea.ipadx = 300;
		gridbagArea.gridx = 0;
		gridbagArea.gridy = 0;
		pane.add(jscrollPane, gridbagArea);

		selectFile = new JButton("选择文件夹");
		gridbagC.fill = GridBagConstraints.HORIZONTAL;
		gridbagC.gridx = 0;
		gridbagC.gridy = 1;
		pane.add(selectFile, gridbagC);
		
		selectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
				resultArea.setText(filesUrl);
			}
		});

		providerButton = new JButton("全程跟踪筛选报表");
		gridbagC.fill = GridBagConstraints.HORIZONTAL;
		gridbagC.gridx = 0;
		gridbagC.gridy = 2;
		pane.add(providerButton, gridbagC);

		providerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullProcessAction fpAction = new FullProcessAction();
				fpAction.getDispatchingOfficeExcel(filesUrl);
				String message = resultArea.getText() + "\n"
						+ "全程跟踪筛选报表！文件名：上行邮件封发局.xls";
				resultArea.setText(message);
			}
		});

	}

}
