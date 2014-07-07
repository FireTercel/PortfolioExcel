package poi.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

import poi.action.SummaryHSSF;
import poi.bean.BaseBean;
import poi.bean.CodeInit;
import poi.bean.CodeNameCollection;
import poi.bean.CodeTree;
import poi.bean.PackObject;
import poi.fileUitl.FileFormat;

/**
 * 写入Excel表格的功能类
 * 
 * @author 唐东宇
 * 
 */
public class ExcelWriter {
	@SuppressWarnings("unused")
	private POIFSFileSystem fs;
	private OutputStream os;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;

	public ExcelWriter() {

	}

	public ExcelWriter(OutputStream os) {
		this.os = os;
		wb = new HSSFWorkbook();
	}

	/**
	 * 向新的Excel文件写入表格标题
	 * 
	 * @param title
	 */
	public void writeExcelTitle(String[] title) {
		// 建立excel对象，表单，以及第一行。
		sheet = wb.createSheet();
		row = sheet.createRow(0);
		HSSFCell cell = null;
		// 将标题写进第一行
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		try {
			wb.write(os);
			// os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeExcelTItleForSheet2(String[] title,String sheetName) {
		// 建立excel对象，表单，以及第一行。
		sheet = wb.createSheet(sheetName);
		row = sheet.createRow(0);
		HSSFCell cell = null;
		// 将标题写进第一行
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		try {
			wb.write(os);
			// os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 向新的Excel文件写入表格内容
	 * 
	 * @param content
	 * @param url
	 */
	public void writeExcelContent(Map<Integer, String> content, String url,
			String conn) {
		try {
			// 获得第一个sheet
			sheet = wb.getSheetAt(0); // 参数可以为sheet命名
			HSSFCell cell = null;
			os = new FileOutputStream(url);

			int rowNum = content.size();
			System.out.println("内容总行数：" + rowNum);
			// 获得总列数
			// int colNum = setCellForCollection(content.get(1)).length;
			// System.out.println("内容总列数：" + colNum);
			for (int i = 1; i <= rowNum; i++) {

				// 获得总列数
				int colNum = setCellForCollection(content.get(i)).length;
				String[] rowValue = setCellForCollection(content.get(i));
				int j = 0;
				int n = 2;
				row = sheet.createRow(i);
				if (conn.equals("style")) {
					row.setHeightInPoints(20);
					CellStyle cellStyle = SummaryHSSF.createStyleCell(wb);
					while (j < colNum) {

						// ----------------------------单元格格式条件---------------------------------------
						// 设置每个sheet每一行的宽度,自动,根据需求自行确定
						sheet.autoSizeColumn(j + 1, true);
						// 创建一个基本的样式

						// ----------------------------单元格格式条件---------------------------------------

						cell = row.createCell(j);

						// ----------------------------单元格格式条件---------------------------------------
						if (j / 2 == n) {
							// 设置文字在单元格里面的位置
							cellStyle = SummaryHSSF.setCellStyleAlignment(
									cellStyle, CellStyle.ALIGN_CENTER,
									CellStyle.VERTICAL_CENTER);
							cellStyle = SummaryHSSF.setFillBackgroundColors(
									cellStyle, IndexedColors.ORANGE.getIndex(),
									IndexedColors.ORANGE.getIndex(),
									CellStyle.SOLID_FOREGROUND);
							cell.setCellStyle(cellStyle);
							n++;
						}
						// ----------------------------单元格格式条件---------------------------------------

						cell.setCellValue(rowValue[j]);
						j++;
					}
				} else {

					while (j < colNum) {
						cell = row.createCell(j);
						cell.setCellValue(rowValue[j]);
						j++;
					}
				}

			}
			wb.write(os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeExcelContentForSheet2(Map<Integer, String> content,
			String url) {
		try {
			// 获得第一个sheet
			sheet = wb.getSheetAt(1); // 参数可以为sheet命名
			HSSFCell cell = null;
			os = new FileOutputStream(url);

			int rowNum = content.size();
			System.out.println("内容总行数：" + rowNum);
			// 获得总列数
			// int colNum = setCellForCollection(content.get(1)).length;
			// System.out.println("内容总列数：" + colNum);
			for (int i = 1; i <= rowNum; i++) {

				row = sheet.createRow(i);
				// 获得总列数
				int colNum = setCellForCollection(content.get(i)).length;
				String[] rowValue = setCellForCollection(content.get(i));
				int j = 0;
				while (j < colNum) {
					cell = row.createCell(j);
					cell.setCellValue(rowValue[j]);

					j++;
				}
			}
			wb.write(os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得Excel文件中，总包号码字段，保存在一个数组String[]里面
	 * 
	 * @param content
	 * @param url
	 * @return 总包号码数组
	 */
	public String[] getPackageNumForContent(Map<Integer, String> content,
			String url) {

		int rowNum = content.size();
		System.out.println("内容总行数：" + rowNum);
		// 获得总列数
		int colNum = setCellForCollection(content.get(1)).length;
		System.out.println("内容总列数：" + colNum);

		// 总包号码数组。
		String[] packageNum = new String[rowNum];
		// 截取总包号码中寄达局邮编，保存在数组中。
		String[] aimOffice = new String[rowNum];

		for (int i = 0; i < rowNum; i++) {
			packageNum[i] = setCellForCollection(content.get(i + 1))[colNum - 1];
			aimOffice[i] = packageNum[i].substring(8, 16);
		}
		return aimOffice;

	}

	/**
	 * 获得Excel文件中，获得原寄局、寄达局、总包号码、重量，保存在一个数组PackObject[]里面
	 * 
	 * @param content
	 * @param url
	 * @return packObjects总包分割内容数组类
	 */
	public PackObject[] getPackObcectForContent(Map<Integer, String> content,
			String url) {
		int rowNum = content.size();
		System.out.println("内容总行数：" + rowNum);
		// 获得总列数
		int colNum = setCellForCollection(content.get(1)).length;
		System.out.println("内容总列数：" + colNum);
		// 总包号码数组。
		String[] packageNum = new String[rowNum];
		// 截取总包号码中原寄局，寄达局，重量邮编，保存在数组中。
		PackObject[] packObjects = new PackObject[rowNum];

		for (int i = 0; i < rowNum; i++) {
			// PackObject packObject=new PackObject();
			packObjects[i] = new PackObject();
			packageNum[i] = setCellForCollection(content.get(i + 1))[colNum - 1];

			if (packageNum[i].length() == 30) {
				packObjects[i].setSourceOffice(packageNum[i].substring(0, 8));
				packObjects[i].setAimOffice(packageNum[i].substring(8, 16));
				packObjects[i].setPackNum(packageNum[i].substring(20, 24));
				String weightstr = packageNum[i].substring(24, 27) + "."
						+ packageNum[i].substring(27, 28);
				double weight = Double.parseDouble(weightstr);
				packObjects[i].setWeight(weight);
			} else {
				packObjects[i].setSourceOffice("00000000");
				packObjects[i].setAimOffice("00000000");
				packObjects[i].setPackNum("0000");
				packObjects[i].setWeight(0.0);
			}

			// System.out.println(packObjects[i]);
		}

		return packObjects;

	}

	/**
	 * 获得总包号码，保存在一个集合中，集合的值为PackObject类
	 * 
	 * @param content
	 * @param url
	 * @return
	 */
	public Map<Integer, PackObject> getPackObjectForContent(
			Map<Integer, String> content, String url) {
		// 保存总包号码信息集合
		Map<Integer, PackObject> packCollection = new HashMap<Integer, PackObject>();
		int rowNum = content.size();
		System.out.println("内容总行数：" + rowNum);
		// 获得总列数
		int colNum = setCellForCollection(content.get(1)).length;
		System.out.println("内容总列数：" + colNum);
		/*
		 * String str="430000005180000011311853003030"; String
		 * weithts=str.substring(24, 28); String w="0125"; double weight=1;
		 * String w2=w.substring(0, 3)+"."+w.substring(3, 4); double
		 * w3=Double.parseDouble(w2);
		 * System.out.println("重量：======"+weithts+"***"+w3);
		 */

		// 总包号码数组。
		String[] packageNum = new String[rowNum];
		for (int i = 0; i < rowNum; i++) {
			PackObject packObject = new PackObject();
			packageNum[i] = setCellForCollection(content.get(i + 1))[colNum - 1];
			// 总包号码
			packObject.setPackNum(packageNum[i].substring(20, 24));
			// 原寄局
			packObject.setSourceOffice(packageNum[i].substring(0, 8));
			// 寄达局
			packObject.setAimOffice(packageNum[i].substring(8, 16));
			double weight = Double.parseDouble(packageNum[i].substring(24, 27)
					+ "." + packageNum[i].substring(27, 28));
			packObject.setWeight(weight);
			// System.out.println(packObject.getPackNum()+"==="+packObject.getSourceOffice()+"==="+packObject.getAimOffice()+"***"+packObject.getWeight());
			packCollection.put(i, packObject);
		}
		return packCollection;
	}

	/**
	 * 
	 * @param content
	 * @param url
	 * @return 返回结果：邮路信息中，总包邮件的所有信息，保存在Bean中。
	 * 同时包括该总包号码是否异常标识，以及packObj对象。
	 * @time 2014-6-26
	 */
	public BaseBean[] getBaseBeanForContent(Map<Integer, String> content,
			String url) {
		int rowNum = content.size();
		System.out.println("内容总行数：" + rowNum);
		// 获得总列数
		int colNum = setCellForCollection(content.get(1)).length;
		System.out.println("内容总列数：" + colNum);

		BaseBean[] baseBean = new BaseBean[rowNum];

		for (int i = 0; i < rowNum; i++) {
			String info = content.get(i + 1);
			String[] infos = info.split("/");
			baseBean[i] = new BaseBean();

			baseBean[i].setPack_num(infos[0]);
			baseBean[i].setSource_office(infos[1]);
			baseBean[i].setAim_office(infos[2]);
			baseBean[i].setMail_type(infos[3]);
			baseBean[i].setDispatch_date(infos[4]);
			baseBean[i].setWeight(infos[5]);
			baseBean[i].setMailbag_type(infos[6]);
			baseBean[i].setRemark(infos[7]);
			baseBean[i].setPack_bar_code(infos[8]);
			
			if(infos[8].length()==30){
				
				baseBean[i].setFlag(true);
				PackObject packObj=new PackObject();
				baseBean[i].setPackobject(packObj);
				
				baseBean[i].getPackobject().setSourceOffice(infos[8].substring(0, 8));
				baseBean[i].getPackobject().setAimOffice(infos[8].substring(8, 16));
				baseBean[i].getPackobject().setPackNum(infos[8].substring(20, 24));
				String weightstr=infos[8].substring(24, 27)+"."+infos[8].substring(27, 28);
				double weight=Double.parseDouble(weightstr);
				baseBean[i].getPackobject().setWeight(weight);
				
			}else{
				baseBean[i].setFlag(false);
				
			}
			
		}

		return baseBean;

	}
	
	

	/**
	 * 统计各个寄达局总包数量，保存在一个Map集合里面。 KEY为机构代码。
	 * 
	 * @param aimOfficeString
	 * @return 返回“各寄达局总包数”集合
	 */
	public HashMap<String, Integer> countAimOffice(String[] pack) {
		HashMap<String, Integer> aimCountMap = new HashMap<String, Integer>();
		int counter = 0;
		for (int i = 0; i < pack.length; i++) {
			if (aimCountMap.containsKey(pack[i])) {
				counter = (Integer) aimCountMap.get(pack[i]);
				aimCountMap.put(pack[i], ++counter);
			} else {
				aimCountMap.put(pack[i], 1);
			}
		}

		return aimCountMap;
	}

	/**
	 * 根据参数packObject[] ，统计各路向总包袋数、重量。
	 * 
	 * @param packObjects
	 * @param conn
	 * @return CodeTree，即各路向结果集合
	 */
	public CodeTree[] countPackObject(PackObject[] packObjects, String conn) {
		CodeInit codeInit = new CodeInit();

		CodeTree[] codetrees = null;

		if (conn.equals("GD")) {
			codetrees = codeInit.initCodeForProvider();
		} else if (conn.equals("SJ")) {
			codetrees = codeInit.initCodeForPostroad();
		} else if (conn.equals("LL")) {
			codetrees = codeInit.initCodeForOutPro();
		}

		PackObject[] packObj = packObjects;
		// 参数->总包类中对象的数量。
		int numObj = packObj.length;
		boolean flag = false;
		int codenum = codetrees.length;

		for (int k = 0; k < numObj; k++) {
			flag = false;
			for (int i = 0; i < codenum; i++) {
				if (flag == true) {
					break;
				}
				if (i < codenum - 1) {
					String[] subNames = codetrees[i].getSubNames();
					for (int j = 0; j < subNames.length; j++) {
						if (packObj[k].getAimOffice().equals(subNames[j])) {
							codetrees[i].setCount(codetrees[i].getCount() + 1);
							codetrees[i].setWeights(codetrees[i].getWeights()
									+ packObj[k].getWeight());
							flag = true;
							break;
						}
					}
				} else if (i == (codenum - 1)) {

					codetrees[codenum - 1].setCount(codetrees[codenum - 1]
							.getCount() + 1);
					codetrees[codenum - 1].setWeights(codetrees[codenum - 1]
							.getWeights() + packObj[k].getWeight());
					break;
				}
			}
		}

		return codetrees;
	}

	/**
	 * 根据传入的参数baseBean，统计各路向总包袋数、重量。
	 * @param baseBean
	 * @param conn
	 * @return CodeTree，即各路向结果集合
	 */
	public CodeTree[] countBaseBean(BaseBean[] baseBean, String conn) {
		CodeInit codeInit = new CodeInit();

		CodeTree[] codetrees = null;

		if (conn.equals("GD")) {
			codetrees = codeInit.initCodeForProvider();
		} else if (conn.equals("SJ")) {
			codetrees = codeInit.initCodeForPostroad();
		} else if (conn.equals("LL")) {
			codetrees = codeInit.initCodeForOutPro();
		}
		
		BaseBean[] baseBeans=baseBean;
		// 参数->总包类中对象的数量。
		int numObj = baseBeans.length;
		boolean flag = false;
		int codenum = codetrees.length;
		
		for(int i=0;i<baseBean.length;i++){
			baseBean[i].getPack_bar_code();
		}
		
		return codetrees;
		
	}

	/**
	 * 将集合aimCountMap机构代码装换成中文，保存为resultMap
	 * 
	 * @param aimCountMap
	 * @return resultMap 已转换成中文的Map集合
	 */
	public HashMap<String, Integer> changeMaptoSerial(
			HashMap<String, Integer> aimCountMap) {
		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();

		try {
			Class cla = Class.forName("poi.bean.CodeNameCollection");
			Field[] fieldlist = cla.getDeclaredFields();
			String fieldName = "";
			for (int i = 0; i < fieldlist.length; i++) {
				fieldName = fieldlist[i].getName();

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;

	}

	/**
	 * 将整个Excel文档内容转换成一条String字符
	 * 
	 * @param aimCountMap
	 * @param fileURL
	 * @return str 将要输出的Excel报表中一行。
	 */
	public String getEachExcelPackCount(HashMap<String, Integer> aimCountMap,
			String fileURL) {
		CodeNameCollection cnc = new CodeNameCollection();
		HashMap<String, Integer> countMap = aimCountMap;
		Set<String> keySet = countMap.keySet();
		String[] keys = new String[keySet.size() + 1];
		Iterator<String> it = keySet.iterator();
		int i = 0;
		while (it.hasNext()) {
			String key = (String) it.next();
			keys[i] = key;
			i++;
		}

		// 邮路名称
		String namePostroad = "";
		// 车牌号码
		String nameLicence = "";
		// 发送时间
		Date nameDate = null;
		String nameDateString = null;
		// 预计到达时间
		Date newNameDate = null;
		String newNameDateString = null;

		String str = "";
		StringBuffer sbuffer = new StringBuffer();

		FileFormat fileFormat = new FileFormat();
		// 将文件名的所有信息保存到fileFormat对象里面。
		fileFormat.setFileNameForCollection(fileURL);
		if (fileFormat.getNameDate() == null) {
			System.out.println("文件命名错误，获取不到文件“" + fileFormat.getFileName()
					+ "”的邮路发送时间！");
			return "";
		} else {
			fileFormat.simpleSetNewDate();
			namePostroad = fileFormat.getNamePostroad();
			nameLicence = fileFormat.getNameLicence();
			nameDate = fileFormat.getNameDate();
			nameDateString = fileFormat.getNameDateString();
			newNameDate = fileFormat.getNewNameDate();

			System.out.println("*************");
			System.out.println("邮路名称：" + namePostroad);
			System.out.println("车牌号码：" + nameLicence);
			System.out.println("发送时间：" + nameDate);
			System.out.println("预计时间：" + newNameDate);
			System.out.println("*************");
			System.out.println("");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmm");
			newNameDateString = sdf.format(newNameDate);
			sbuffer.append(nameDateString + "/" + namePostroad + "/"
					+ newNameDateString + "/" + nameLicence + "/");
			for (int j = 0; j < keys.length - 1; j++) {
				sbuffer.append(cnc.makeCodeForCN(keys[j]) + "/");
				sbuffer.append(countMap.get(keys[j]) + "/");
			}
			str = sbuffer.toString();

			return str;

		}

	}

	public String getEachExcelPackObject(CodeTree[] codetree, String fileURL) {

		CodeTree[] codetrees = codetree;

		// 邮路名称
		String namePostroad = "";
		// 车牌号码
		String nameLicence = "";
		// 发送时间
		Date nameDate = null;
		String nameDateString = "";
		// 预计到达时间
		Date newNameDate = null;
		String newNameDateString = "";
		// 返回结果
		String str = "";

		StringBuffer sbuffer = new StringBuffer();

		FileFormat fileFormat = new FileFormat();
		// 将文件名的所有信息保存到fileFormat对象里面。
		fileFormat.setFileNameForCollection(fileURL);
		if (fileFormat.getNameDate() == null) {
			System.out.println("文件命名错误，获取不到文件“" + fileFormat.getFileName()
					+ "”的邮路发送时间！");
			return "";
		} else {
			fileFormat.simpleSetNewDate();
			namePostroad = fileFormat.getNamePostroad();
			nameLicence = fileFormat.getNameLicence();
			nameDate = fileFormat.getNameDate();
			nameDateString = fileFormat.getNameDateString();
			newNameDate = fileFormat.getNewNameDate();

			System.out.println("*************");
			System.out.println("邮路名称：" + namePostroad);
			System.out.println("车牌号码：" + nameLicence);
			System.out.println("发送时间：" + nameDate);
			System.out.println("预计时间：" + newNameDate);
			System.out.println("*************");
			System.out.println("");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmm");
			newNameDateString = sdf.format(newNameDate);
			sbuffer.append(nameDateString + "/" + namePostroad + "/"
					+ newNameDateString + "/" + nameLicence + "/");
			DecimalFormat df = new DecimalFormat("0.00");
			for (int i = 0; i < codetrees.length; i++) {
				sbuffer.append(codetrees[i].getCount() + "/");
				double weight = codetrees[i].getWeights();
				String w = df.format(weight);
				sbuffer.append(w + "/");
				// sbuffer.append(codetrees[i].getWeights() + "/");
			}
			str = sbuffer.toString();

		}

		return str;

	}

	public Map<Integer, String> getPackObject(CodeTree[] codetree) {
		// 保存最终结果
		Map<Integer, String> endContent = new HashMap<Integer, String>();
		CodeTree[] codetrees = codetree;
		// 返回结果
		String str = "";

		DecimalFormat df = new DecimalFormat("0.00");

		for (int i = 0; i < codetrees.length; i++) {
			StringBuffer sbuffer = new StringBuffer();
			sbuffer.append((i + 1) + "/");
			sbuffer.append(codetrees[i].getNodeName() + "/");
			sbuffer.append(codetrees[i].getCount() + "/");
			double weight = codetrees[i].getWeights();
			String w = df.format(weight);
			sbuffer.append(w + "/");
			String endString = sbuffer.toString();
			// sbuffer.append(codetrees[i].getWeights() + "/");
			endContent.put(i + 1, endString);

		}

		return endContent;
	}

	/**
	 * 将一个单元格的数据，根据分隔符条件“/”，拆分成数组，用于给多个单元格赋值
	 * 
	 * @param cellValue
	 * @return
	 */
	public String[] setCellForCollection(String cellValue) {
		String[] rowValue = { "", "", "", "" };
		if (cellValue == null) {

		} else {
			rowValue = cellValue.split("/");
		}

		return rowValue;
	}

	/**
	 * 将总包号码集合（参数为packObject类）， 先把机构代码转换成中文，然后构造成Map<Integer, String>
	 * 
	 * @param packObject
	 * @return endContent 结果集合Map，value为导出Excel表每一行数据
	 */
	public Map<Integer, String> makePackObjectForMap(
			Map<Integer, PackObject> packObject) {
		CodeNameCollection cnc = new CodeNameCollection();
		Map<Integer, PackObject> packs = new HashMap<Integer, PackObject>();
		Map<Integer, String> endContent = new HashMap<Integer, String>();
		packs = packObject;
		// 原寄局
		String sourceOffice = "";
		// 寄达局
		String aimOffice = "";

		String endString = "";

		for (int i = 0; i < packs.size(); i++) {
			PackObject tempPack = new PackObject();
			tempPack = packs.get(i);
			sourceOffice = cnc.makeCodeForCN(tempPack.getSourceOffice());
			aimOffice = cnc.makeCodeForCN(tempPack.getAimOffice());
			tempPack.setSourceOffice(sourceOffice);
			tempPack.setAimOffice(aimOffice);
			packs.put(i, tempPack);
			endString = tempPack.getPackNum() + "/"
					+ tempPack.getSourceOffice() + "/"
					+ tempPack.getAimOffice() + "/" + tempPack.getWeight();
			endContent.put(i + 1, endString);
		}
		return endContent;
	}

	/**
	 * 提取总包类集合中寄达局属性，放到数组中
	 * 
	 * @param packObject
	 * @return 寄达局数组
	 */
	public String[] getPackObjectForNum(Map<Integer, PackObject> packObject) {
		Map<Integer, PackObject> packsMap = new HashMap<Integer, PackObject>();
		packsMap = packObject;

		// 保存总包号码
		String[] pack = new String[packObject.size()];

		for (int i = 0; i < pack.length; i++) {
			PackObject object = new PackObject();
			object = packsMap.get(i);
			pack[i] = object.getAimOffice();
		}
		return pack;

	}

	/**
	 * 将寄达局统计集合，转换成Excel文件每一行数据，保存到集合中
	 * 
	 * @param aimCountMap
	 * @return endContent 最终结果集合
	 */
	public Map<Integer, String> makePackObjectForCountMap(
			HashMap<String, Integer> aimCountMap) {
		Map<Integer, String> endContent = new HashMap<Integer, String>();
		HashMap<String, Integer> countMap = aimCountMap;
		Set<String> keySet = countMap.keySet();
		String[] keys = new String[keySet.size() + 1];
		Iterator<String> it = keySet.iterator();
		int i = 0;
		while (it.hasNext()) {
			String key = (String) it.next();
			keys[i] = key;
			i++;
		}

		String str = "";
		StringBuffer sbuffer = new StringBuffer();

		for (int j = 0; j < keys.length - 1; j++) {

			str = keys[j] + "/" + countMap.get(keys[j]);
			endContent.put(j + 1, str);

		}

		return endContent;
	}

	public static CellStyle createStyleCell(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();
		// 设置一个单元格边框颜色
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// 设置一个单元格边框颜色
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return cellStyle;
	}

	public static CellStyle setCellStyleAlignment(CellStyle cellStyle,
			short halign, short valign) {
		// 设置上下
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 设置左右
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return cellStyle;
	}

	public static CellStyle setCellFormat(CreationHelper helper,
			CellStyle cellStyle, String fmt) {
		// 还可以用其它方法创建format
		cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));
		return cellStyle;
	}

	public static CellStyle setFillBackgroundColors(CellStyle cellStyle,
			short bg, short fg, short fp) {
		// cellStyle.setFillBackgroundColor(bg);
		cellStyle.setFillForegroundColor(fg);
		cellStyle.setFillPattern(fp);
		return cellStyle;
	}

	public static Font createFonts(Workbook wb) {
		// 创建Font对象
		Font font = wb.createFont();
		// 设置字体
		font.setFontName("黑体");
		// 着色
		font.setColor(HSSFColor.BLUE.index);
		// 斜体
		font.setItalic(true);
		// 字体大小
		font.setFontHeight((short) 300);
		return font;
	}

	public static void main(String[] args) {
		/*
		 * ExcelWriter writer = new ExcelWriter(); Map<Integer, String> content
		 * = new HashMap<Integer, String>();
		 * writer.getPackObjectForContent(content, "");
		 */

		String str = "529500215284010011216067005610";
		String one = str.substring(0, 8);
		String two = str.substring(8, 16);
		String three = str.substring(20, 24);
		String five = str.substring(24, 27);
		String six = str.substring(27, 28);
		double four = Double.parseDouble(str.substring(24, 27) + "."
				+ str.substring(27, 28));
		System.out.println("     	one===" + four + "     	one===" + five
				+ "     	one===" + six);

	}

}
