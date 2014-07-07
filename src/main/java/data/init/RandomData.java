package data.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextField;

import data.adt.CollectMap;
import data.adt.Workmates;
import data.thread.StatusThread;

/**
 * 随机类，随机获得员工信息，输出结果。
 * @author 唐东宇
 *
 */
public class RandomData { 

	private static RandomData randomData = null;

	private CollectMap collectMap;
	private CollectMap finishedMap;
	@SuppressWarnings("rawtypes")
	private Map randomMap;
	private StatusThread statusThread; 
	
	//作为参数，传输random到的结果
	@SuppressWarnings("unused")
	private static JTextField resultField;// 结果显示

	// 12.5输入继续循环标识.
	private Scanner input;
	
	// 1.12标识，该标识用于为boolean类型，用于判断继续循环标识
	@SuppressWarnings("unused")
	private boolean contin;

	// 12.4单例模式
	private RandomData() {
	}

	private static synchronized void syncInit() {
		if (randomData == null) {
			randomData = new RandomData();
		}
	}

	public static RandomData getInstance() {
		if (randomData == null)
			syncInit();
		return randomData;
	}

	/**
	 *  11.25主方法，抽奖器运行主要方法。
	 * @param times
	 * @param resultField
	 */
	@SuppressWarnings("rawtypes")
	public void runRandom(int times,JTextField resultField) {
		collectMap = new CollectMap();
		
		randomMap = new HashMap();

		Workmates workmateTemp = new Workmates();
		
		//此两个标识用途一样，只是contin用于界面按钮控制。
		String string = null;
		contin=false;
		
		statusThread = new StatusThread();

		randomMap = collectMap.insertMapData();// 赋值

		int[] intRet = new int[times];
		int intRd = 0;// 存放随机数。
		int count = 0;// 记录生成的随机数个数。
		int flag = 0;// 判断是否已经生成过的标识。
		int outCycle = 1;// 判断是否退出循环的标识.1为退0为继续
		boolean flagCycle = false;// 判断循环是否结束false 未结束，true 结束。

		for (int i = 0; i < times; i++) {
			System.out.println("= = = = 是否开始? = = = (Y->是\\N->否)= = = =");
			input = new Scanner(System.in);
			string = input.next();
			System.out.println("= = = " + string + " = = =");
			if (string.equals("Y")) {
				Random rdm = new Random(System.currentTimeMillis());
				new Thread(statusThread).start();

				while (flagCycle == false) {
					// intRd=Math.abs(rdm.nextInt())%30+1;
					// System.out.println(intRd);
					// 使获得数据不重复
					flag = 0;
					outCycle = 1;
					while (flag == 0) {
						intRd = Math.abs(rdm.nextInt()) % 30 + 1;
						System.out.println(intRd - 1);
						for (int j = 0; j < count; j++) {
							if (intRet[j] == intRd) {
								outCycle = 0;
								flag = 0;
								break;
							} else {
								flag = 1;
							}
						}
						if (outCycle == 1) {
							// intRet[count]=intRd;
							// count++;
							flag = 1;
						}
					}

					workmateTemp = (Workmates) randomMap.get(intRd);
					System.out.println(workmateTemp.getName() + "---"
							+ workmateTemp.getPhoneNumber());

					try {

						flagCycle = statusThread.isFlag();
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (flagCycle == false) {
					workmateTemp = null;
				} else if (flagCycle == true) {
					intRet[count] = intRd;
					count++;
				}
				flagCycle = false;
				statusThread.setFlag(false);
				string = "";
			} else if (string.equals("N")) {
				System.out.println("= = = = 放弃该机会! = = = = =");
			} else
				System.out.println("error!");
		}
		getFinishedMap(intRet);

	}
	/*
	 * public static void main(String[] args){ RandomData ranData=new
	 * RandomData(); ranData.runRandom(5);
	 * 
	 * }
	 */
	
	/**
	 * 获得最终结果集合
	 * @param intResults
	 */
	@SuppressWarnings("unchecked")
	public void getFinishedMap(int[] intResults){
		
		int[] results=intResults;
		finishedMap = new CollectMap();
		Workmates workmates;
		
		for(int i=0;i<results.length;i++){
			workmates=(Workmates) randomMap.get(results[i]);
			finishedMap.put(i, workmates);
		}
		
		System.out.println("本次获奖名单:");
		for(int i=0;i<results.length;i++){
			workmates=(Workmates)finishedMap.get(i);
			System.out.println(workmates.getName() + "---"
					+ workmates.getPhoneNumber());
		}
		
	}

}
