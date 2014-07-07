package poi.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import poi.fileUitl.FileFormat;

/**
 * 读取Excel表格的功能类
 * @author 唐东宇
 *
 */
public class ExcelReader {
	private POIFSFileSystem fs; 
	private HSSFWorkbook wb;
	private HSSFSheet sheet; 
	private HSSFRow row; 
 
	private String p_startDate;
	private String p_endDate;
	 
	

	public String getP_startDate() {
		return p_startDate; 
	}

	public void setP_startDate(String p_startDate) {
		this.p_startDate = p_startDate;
	}

	public String getP_endDate() {
		return p_endDate;
	}

	public void setP_endDate(String p_endDate) {
		this.p_endDate = p_endDate;
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 */
	@SuppressWarnings("deprecation")
	public String[] readExcelTitle(InputStream is) {
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("标题总列数：" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			// title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = getCellFormatValue(row.getCell((short) i));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 */
	@SuppressWarnings("deprecation")
	public Map<Integer, String> readExcelContent(InputStream is) {
		Map<Integer, String> content = new HashMap<Integer, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		// 获得总列数
		//int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			// 获得总列数
			int colNum = row.getPhysicalNumberOfCells();
			int j = 0;
			while (j < colNum) {			// j的数据从0-8，因为colNum=9
				// 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
				// 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
				// str += getStringCellValue(row.getCell((short) j)).trim() +
				// "-";
				// getCell(j)定位到row行的j+1单元格
				str += getCellFormatValue(row.getCell((short) j)).trim() + "/";
				j++;
			}
			// 每一行，Map数据就加一个
			content.put(i, str);
			// str清空数据
			str = "";
		}
		return content;
	}

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	@SuppressWarnings("unused")
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}

	/**
	 * 获取单元格数据内容为日期类型的数据
	 * 
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	private String getDateCellValue(HSSFCell cell) {
		String result = "";
		try {
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				Date date = cell.getDateCellValue();
				result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
						+ "-" + date.getDate();
			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
				String date = getStringCellValue(cell);
				result = date.replaceAll("[年月]", "-").replace("日", "").trim();
			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
				result = "";
			}
		} catch (Exception e) {
			System.out.println("日期格式不正确!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据HSSFCell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// 如果当前Cell的Type为NUMERIC
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式

					// 方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();

					// 方法2：这样子的data格式是不带带时分秒的：2011-10-12
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);

				}
				// 如果是纯数字
				else {
					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			// 如果当前Cell的Type为STRING
			case HSSFCell.CELL_TYPE_STRING:
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 默认的Cell值
			default:
				cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}

	

	/**
	 * 根据指定时间范围，返回该时间段预计到达的邮路
	 * @param fileURL
	 * @param p_startDate
	 * @param p_endDate
	 * @return 时间范围邮路文件名集合
	 */
	public String[] getExcelFileCollectionForDate(String fileURL,String p_startDate, String p_endDate) {
		
		String[] excelCondition=null;
		//保存符合时间范围的文件名称
		Map<Integer, String> map=new HashMap<Integer, String>();
		int count=0;
		FileFormat file=new FileFormat();

		String[] excelList = file.getExcelFileCollection(fileURL);
		// excelLists=this.getExcelFileCollection(fileURL);
		System.out.println("该文件夹总共有："+excelList.length+"个Excel文件！");
		for (int i = 0; i < excelList.length; i++) {
			FileFormat fileFormat = new FileFormat();
			System.out.println("================================");
			fileFormat.setFileNameForCollection(excelList[i]);
			System.out.println("文件名呢？" + fileFormat.getFileName());
			System.out.println(fileFormat.getNameDate()+" ***");
			System.out.println(fileFormat.getNamePostroadSimple()+" ***");
			int timeflag=fileFormat.getPropertiesPostroadTime(fileFormat.getNamePostroadSimple());
			System.out.println(timeflag+" ***"); 
			Date date=null;
			if(timeflag==0){
				System.out.println("文件命名错误，请修改！");
			}else{
				date = fileFormat.addnameDate(fileFormat.getNameDate(), fileFormat.getPropertiesPostroadTime(fileFormat.getNamePostroadSimple()));
				System.out.println("date:"+date);
				if(fileFormat.isPostroadBetweenTime(p_startDate, p_endDate, date)){
					System.out.println(fileFormat.getFileName()); 
					map.put(count, fileFormat.getFileName());
					count++;
				}
					
			}
			
		}
		System.out.println("== == ==		符合条件且成功合并的文件数量为：<  "+map.size()+"  >	== == ==");
		excelCondition=new String[map.size()];
		for(int i=0;i<map.size();i++){
			System.out.println("已合并Excel文件名："+map.get(i));
			excelCondition[i]=map.get(i);
		}

		return excelCondition;

	}
	
	/**
	 * 初始化开始、结束日期。
	 * @param p_startDate
	 * @param p_endDate
	 * @return
	 */
	public void initStartEndDate(String p_startDate,String p_endDate){
		this.p_startDate=p_startDate;
		this.p_endDate=p_endDate;
		
	}

	/**
	 * 获得所有Excel文件的内容，保存在同一个Map中
	 * 
	 * @param is
	 * @return Map<Integer, String> 返回所有Excel文件内容
	 * 
	 */
	@SuppressWarnings("unused")
	public Map<Integer, String> readAllExcelContent(String fileURL,String condition) {
		String[] allExcelFiles=null;
		FileFormat file=new FileFormat();
		
		if(condition.equals("ALL")){
			allExcelFiles=file.getExcelFileCollection(fileURL); //Excel文件名集合
		}else if(condition.equals("COND")){
			
			allExcelFiles = getExcelFileCollectionForDate(fileURL,
					this.p_startDate, this.p_endDate);
		}
		
		int filesNum = allExcelFiles.length; // Excel文件数
		Map<Integer, String> content = new HashMap<Integer, String>(); // 用来获取单个Excel文件内容
		Map<Integer, String> contents = new HashMap<Integer, String>(); // 用来保存所有Excel文件内容
		String str = "";

		InputStream inputStream = null;

		for (int i = 0; i < filesNum; i++) {
			System.out.println("读取Excel文件路径：" + fileURL + allExcelFiles[i]);
			try {
				inputStream = new FileInputStream(fileURL + allExcelFiles[i]);
				content = readExcelContent(inputStream);
				mergeAllMap(contents, content);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("未找到指定路径的文件!");
				e.printStackTrace();
			}
		}

		return contents;

	}

	/**
	 * 将第二个Map数据添加合并到第一个Map里面
	 * 
	 * @param contents
	 * @param content
	 */
	public void mergeAllMap(Map<Integer, String> firstContents,
			Map<Integer, String> secondContent) {
		int sourConsNum = firstContents.size();
		int addConNum = secondContent.size();
		for (int i = 1; i <= addConNum; i++) {
			firstContents.put(sourConsNum + i, secondContent.get(i));
		}
	}

	public static void main(String[] args) {
		try {
			// 对读取Excel表格标题测试
			InputStream is = new FileInputStream("d:\\test\\广州西安336.xls");
			ExcelReader excelReader = new ExcelReader();
			String[] title = excelReader.readExcelTitle(is);
			System.out.println("获得Excel表格的标题:");
			for (String s : title) {
				System.out.print(s + " ");
			}
			System.out.println();

			// 对读取Excel表格内容测试
			InputStream is2 = new FileInputStream("d:\\test\\广州西安336.xls");
			Map<Integer, String> map = excelReader.readExcelContent(is2);
			System.out.println("获得Excel表格的内容:");
			for (int i = 1; i <= map.size(); i++) {
				System.out.println(map.get(i));
			}

		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		}
	}
}