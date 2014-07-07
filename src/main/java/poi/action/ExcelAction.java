package poi.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import poi.bean.BaseBean;
import poi.bean.CodeInit;
import poi.bean.CodeTree;
import poi.bean.PackObject;
import poi.fileUitl.FileCreate;
import poi.fileUitl.FileFormat;
import poi.server.ExcelReader;
import poi.server.ExcelWriter;
 
/**
 * Action
 *  
 * @author 唐东宇 
 *  
 */
public class ExcelAction { 
 
	/**
	 * 方法1：遍历D盘excel文件夹所有文件，找出符合命名规范文件，对每一个文件进行分析。 通过（1）获得文件所有内容，保存为Map<Integer,
	 * String> content （2）获取总包号码字段，保存为String[] pack
	 * （3）分析总包号码寄达局字段，统计各个寄达局数量，保存为HashMap<String, Integer> aimCountMap
	 * （4）获得每行保存结果String endString 结果：输出每条邮路分析结果。
	 * 旧方法，现在不使用
	 */
	@SuppressWarnings("unused")
	public void postroadsForResults(String start, String end) {
		ExcelReader excelReader = new ExcelReader();
		ExcelWriter excelWriter = new ExcelWriter();
		FileFormat fileFormat = new FileFormat();
		FileCreate fileCreate = new FileCreate();

		String fileURL = "D:\\excel\\";
		// 保存所有文件名称
		String[] allExcelFiles = null;

		if (!start.equals("") && !end.equals("")) {
			excelReader.initStartEndDate(start, end);
		} else {
			excelReader.initStartEndDate("2014-1-1 0000", "2014-12-31 2359");
		}
		allExcelFiles = excelReader.getExcelFileCollectionForDate(fileURL,
				excelReader.getP_startDate(), excelReader.getP_endDate());

		// allExcelFiles = fileFormat.getExcelFileCollection(fileURL); //
		// Excel文件名集合

		try {
			// 读取Excel文件标题
			// InputStream is = new FileInputStream("d:\\test\\省际进口标题.xls");
			excelReader = new ExcelReader();
			String[] title = { "发车日期", "路向名称", "预计到达时间", "车牌号码" };

			// 重新写入Excel文件标题
			String url = fileCreate.createFile();
			String fileUrl = fileCreate.createFile(url, "省际汇总") + "\\"
					+ "省际汇总.xls";
			String str = fileUrl;
			OutputStream os = new FileOutputStream(str);
			excelWriter = new ExcelWriter(os);
			excelWriter.writeExcelTitle(title); 

			// 读取Excel文件内容

			InputStream inputStream = null;
			// 保存初始Excel内容
			Map<Integer, String> content = null;
			// 保存总包号码
			String[] pack = null;
			// KEY：寄达局机构代码，VALUE：总包数
			HashMap<String, Integer> aimCountMap = null;
			// 保存最终结果
			Map<Integer, String> endContent = new HashMap<Integer, String>();

			for (int i = 0; i < allExcelFiles.length; i++) {
				inputStream = new FileInputStream(fileURL + allExcelFiles[i]);
				// 单个Excel文件内容
				content = excelReader.readExcelContent(inputStream);
				// 总包号码字段
				pack = excelWriter.getPackageNumForContent(content, str);

				// 寄达局统计
				aimCountMap = excelWriter.countAimOffice(pack);
				// 每行保存结果
				String endString = excelWriter.getEachExcelPackCount(
						aimCountMap, allExcelFiles[i]);
				endContent.put(i + 1, endString);
			}
			excelWriter.writeExcelContent(endContent, str,"style");

		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}

	}

	/**
	 * 新省际汇总报表，按经转关系，将机构代码与路向相对应。
	 * 新方法，现在“省际流量监控”、“进口报表”使用该方法。
	 * @param start
	 * @param end
	 */
	public void newPostroadsForResults(String start, String end,String conn,String filesUrl) {
		ExcelReader excelReader = new ExcelReader();
		ExcelWriter excelWriter = new ExcelWriter();
		FileFormat fileFormat = new FileFormat();
		FileCreate fileCreate = new FileCreate();
  
		String fileURL = filesUrl+"\\";
		// 保存所有文件名称
		String[] allExcelFiles = null;

		if (!start.equals("") && !end.equals("")) {
			excelReader.initStartEndDate(start, end);
		} else {
			excelReader.initStartEndDate("2014-1-1 0000", "2015-12-31 2359");
		}
		allExcelFiles = excelReader.getExcelFileCollectionForDate(fileURL,
				excelReader.getP_startDate(), excelReader.getP_endDate());
		
		try {
			// 读取Excel文件标题
			// InputStream is = new FileInputStream("d:\\test\\省际进口标题.xls");
			excelReader = new ExcelReader();
 
			String[] title_gd = { "发车日期", "路向名称", "预计到达时间", "车牌号码", "广东", "",
					"长沙", "", "无锡", "", "杭州", "", "成都", "", "济南", "", "昆明", "",
					"西安", "", "武汉", "", "郑州", "", "南昌", "", "南宁", "", "贵阳", "",
					"福州", "", "海口", "", "棠溪1", "", "棠溪2", "", "中山三角", "", "未知", "" };
			String[] title_sj = { "发车日期", "路向名称", "预计到达时间", "车牌号码", "湛江", "",
					"茂名", "", "阳江", "", "云浮", "", "肇庆", "", "江门", "", "佛山", "",
					"南海", "", "三水", "", "顺德", "", "广州", "", "番禺", "", "中山", "",
					"清远", "", "韶关", "", "东莞", "", "深圳", "", "惠州", "", "汕尾", "",
					"潮州", "", "揭阳普宁", "", "汕头", "", "梅州", "", "河源	", "",
					"英德佛冈", "", "珠海", "", "长沙", "", "无锡", "", "杭州", "", "成都",
					"", "济南", "", "昆明", "", "西安", "", "武汉", "", "郑州", "", "南昌",
					"", "南宁", "", "贵阳", "", "福州", "", "海口", "", "棠溪1", "",
					"棠溪2", "", "中山三角", "", "未知", "" };

			// 重新写入Excel文件标题
			String url = fileCreate.createFile();
			String fileUrl="";
			if(conn.equals("GD")){
				fileUrl = fileCreate.createFile(url, "进口报表") + "\\"
						+ "进口邮路汇总.xls";
				OutputStream os = new FileOutputStream(fileUrl);
				excelWriter = new ExcelWriter(os);
				excelWriter.writeExcelTitle(title_gd);
			}else if(conn.equals("SJ")){
				fileUrl = fileCreate.createFile(url, "省际汇总") + "\\"
						+ "省际邮路监控.xls";
				OutputStream os = new FileOutputStream(fileUrl);
				excelWriter = new ExcelWriter(os);
				excelWriter.writeExcelTitle(title_sj);
			}

			// -----------------------------------------------------------------------

			// 读取Excel文件内容
			InputStream inputStream = null;
			// 保存初始Excel内容
			Map<Integer, String> content = null;
			// 保存总包号码数组
			PackObject[] packObjects = null;
			
			BaseBean[] baseBean=null;
			
			// KEY：寄达局机构代码，VALUE：总包数
			HashMap<String, Integer> aimCountMap = null;
			// 保存最终结果
			Map<Integer, String> endContent = new HashMap<Integer, String>();

			for (int i = 0; i < allExcelFiles.length; i++) {
				inputStream = new FileInputStream(fileURL + allExcelFiles[i]);
				// 单个Excel文件内容
				content = excelReader.readExcelContent(inputStream);
				// 根据总包号码，筛选出原寄局、寄达局、总包号码、重量。
				packObjects = excelWriter.getPackObcectForContent(content, fileUrl);
				
				baseBean=excelWriter.getBaseBeanForContent(content, fileUrl);
				System.out.println("BaseBean数组长度："+baseBean.length);
				
				// 寄达局统计
				CodeTree[] codetrees = excelWriter.countPackObject(packObjects,
						conn);

				//打印codeInit内容
				/*for (int j = 0; j < codetrees.length; j++) {
					System.out.println(codetrees[j].toString());
				}*/
				// 每行保存结果
				String endString = excelWriter.getEachExcelPackObject(
						codetrees, allExcelFiles[i]); 
				endContent.put(i + 1, endString);

			}
			excelWriter.writeExcelContent(endContent, fileUrl,"style"); 

		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		} 

	}
	
	/** 
	 * 省际出口流量流向功能
	 */
	public void providerOutFlowDire(String conn,String filesUrl){
		try{
			ExcelReader excelReader = new ExcelReader();
			ExcelWriter excelWriter = new ExcelWriter();
			FileFormat fileFormat = new FileFormat();
			FileCreate fileCreate = new FileCreate();
			
			String fileURL = filesUrl+"\\";
			String fileUrl="";
			
			String[] title ={"序号","路向","总包（袋）","重量（千克）"};
			
			String url = fileCreate.createFile();
			fileUrl = fileCreate.createFile(url, "流量流向") + "\\"
					+ "省际出口流量流向.xls";
			OutputStream os = new FileOutputStream(fileUrl);
			excelWriter = new ExcelWriter(os);
			excelWriter.writeExcelTitle(title);
			
			// 读取Excel文件内容
			InputStream inputStream = null;
			// 保存初始Excel内容
			Map<Integer, String> content = null;
			// 保存总包号码数组
			PackObject[] packObjects = null;
			// KEY：寄达局机构代码，VALUE：总包数
			HashMap<String, Integer> aimCountMap = null;
			// 保存最终结果
			Map<Integer, String> endContent = new HashMap<Integer, String>();
			
			
			content=excelReader.readAllExcelContent(fileURL, "ALL");
			// 根据总包号码，筛选出原寄局、寄达局、总包号码、重量。
			packObjects = excelWriter.getPackObcectForContent(content, fileUrl);
			
			// 寄达局统计
			CodeTree[] codetrees = excelWriter.countPackObject(packObjects,
					conn);
			
			endContent= excelWriter.getPackObject(codetrees);

			excelWriter.writeExcelContent(endContent, fileUrl,"none");
			
		}catch(FileNotFoundException e){
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}

	/**
	 * 方法2：提供两种文件合成方式， 一种是将所有文件合成； 另一种是根据时间段筛选符合条件的文件，进行合成。
	 * 修改readAllExcelContent（路径，参数条件：ALL或COND）
	 */
	public void allExcelFileForResult(String start, String end,String filesUrl) {
		try {
			// 读取Excel文件标题
			// InputStream is = new FileInputStream("d:\\test\\标题文件.xls");
			ExcelReader excelReader = new ExcelReader();
			FileCreate fileCreate = new FileCreate();
			String[] title = { "总包号码", "原寄局", "寄达局", "邮件种类", "封发日期", "重量(KG)",
					"邮袋型号", "备注", "总包条码" };

			// 读取Excel文件内容
			String fileURL = filesUrl+"\\";
			if (!start.equals("") && !end.equals("")) {
				excelReader.initStartEndDate(start, end);
			} else {
				excelReader.initStartEndDate("2014-1-1 0000", "2014-12-31 2359");
			}

			Map<Integer, String> content = excelReader.readAllExcelContent(fileURL, "ALL");

			// 读取文件名称
			// excelReader.readAllExcelContent();
			String url = fileCreate.createFile();
			String fileUrl = fileCreate.createFile(url, "平衡合拢") + "\\"+ "合并报表汇总文件.xls";
			// 重新写入Excel文件标题
			String str = fileUrl;
			OutputStream os = new FileOutputStream(str);
			ExcelWriter excelWriter = new ExcelWriter(os);
			excelWriter.writeExcelTitle(title);

			// 重新写入Excel文件内容

			excelWriter.writeExcelContent(content, str,"");
			System.out.println("contents：" + content.size());

			System.out.println("====== ========= ======== ======= ========= ======");

			//String[] pack = excelWriter.getPackageNumForContent(content, str);
			//System.out.println("总包号码数量为：" + pack.length);


		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}

	/**
	 * 方法3：平衡合拢，根据源数据Excel表格内容，获得总包条码数据，解析成中文，生成两个Sheet 第一个保存总包号码，原寄局，寄达局
	 * 第二个保存寄达局、寄达局数量。
	 */
	public void changePackFormatForResult() {
		ExcelReader excelReader = new ExcelReader();
		ExcelWriter excelWriter = new ExcelWriter();
		// FileFormat fileFormat = new FileFormat();
		FileCreate fileCreate = new FileCreate();

		String[] title = { "总包号码", "原寄局", "寄达局", "重量" };
		String[] title2 = { "寄达局", "数量" };

		// 原寄局
		// String sourceOffice="";
		// 寄达局
		// String aimOffice="";

		try {
			String url = fileCreate.createFile();
			String fileUrl = fileCreate.createFile(url, "平衡合拢");
			String fileSource = fileUrl + "\\" + "合并报表汇总文件.xls";
			String fileResult = fileUrl + "\\" + "平衡合拢转换结果.xls";
			// 重新写入Excel文件标题
			InputStream is = new FileInputStream(fileSource);
			Map<Integer, String> content = excelReader.readExcelContent(is);

			// 重新写入Excel文件标题
			String str = fileResult;
			OutputStream os = new FileOutputStream(str);
			excelWriter = new ExcelWriter(os);
			// 写入第一个Sheet标题
			excelWriter.writeExcelTitle(title);
			// 写入第二个Sheet标题
			String sheetName="总包汇总";
			excelWriter.writeExcelTItleForSheet2(title2,sheetName);

			Map<Integer, PackObject> packObject = new HashMap<Integer, PackObject>();
			// 保存最终结果
			Map<Integer, String> endContent = new HashMap<Integer, String>();

			packObject = excelWriter.getPackObjectForContent(content, "");
			endContent = excelWriter.makePackObjectForMap(packObject);
			excelWriter.writeExcelContent(endContent, str,"");

			// 保存第二个Sheet中汇总数据结果
			Map<Integer, String> endCountContent = new HashMap<Integer, String>();
			// 保存总包号码
			String[] pack = null;
			// KEY：寄达局机构代码，VALUE：总包数
			HashMap<String, Integer> aimCountMap = null;

			// 提取总包类集合总包号码
			pack = excelWriter.getPackObjectForNum(packObject);
			aimCountMap = excelWriter.countAimOffice(pack);

			endCountContent = excelWriter
					.makePackObjectForCountMap(aimCountMap);

			excelWriter.writeExcelContentForSheet2(endCountContent, str);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	

}
