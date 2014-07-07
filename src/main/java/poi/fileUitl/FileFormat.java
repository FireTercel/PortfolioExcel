package poi.fileUitl;

import io.stream.MessageFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import date.util.DateUtil;

public class FileFormat extends DateUtil {
 
	// 文件全名 
	private String fileName;
	// 截取邮路简称
	private String namePostroadSimple;
	// 截取邮路名称
	private String namePostroad;
	// 截取车牌号 
	private String nameLicence;
	// 截取发送日期
	private Date nameDate;
	private String nameDateString;
	//计算出预计到达时间
	private Date newNameDate;
	private String newNameDateString;
	
	private String[] excelLists;
	private String message;
	private MessageFile messageFile;

	/**
	 * 获得文件全名
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获得邮路简称
	 * @return
	 */
	public String getNamePostroadSimple() {
		return namePostroadSimple;
	}

	public void setNamePostroadSimple(String namePostroadSimple) {
		this.namePostroadSimple = namePostroadSimple;
	}

	/**
	 * 获得邮路名称
	 * @return
	 */
	public String getNamePostroad() {
		return namePostroad;
	}

	public void setNamePostroad(String namePostroad) {
		this.namePostroad = namePostroad;
	}

	/**
	 * 获得车牌号码
	 * @return
	 */
	public String getNameLicence() {
		return nameLicence;
	}

	public void setNameLicence(String nameLicence) {
		this.nameLicence = nameLicence;
	}

	/**
	 * 获得邮路信息发送时间
	 * @return the nameDate
	 */
	public Date getNameDate() {
		return nameDate;
	}

	/**
	 * @param nameDate
	 *            the nameDate to set
	 */
	public void setNameDate(Date nameDate) {
		this.nameDate = nameDate;
	}

	public Date getNewNameDate() {
		return newNameDate;
	}

	public void setNewNameDate(Date newNameDate) {
		this.newNameDate = newNameDate;
	}

	public String getNameDateString() {
		return nameDateString;
	}

	public void setNameDateString(String nameDateString) {
		this.nameDateString = nameDateString;
	}

	public String getNewNameDateString() {
		return newNameDateString;
	}

	public void setNewNameDateString(String newNameDateString) {
		this.newNameDateString = newNameDateString;
	}

	/**
	 * Excel文件名处理类
	 */
	public FileFormat() {

	}
	
	/**
	 * 获得文件夹中所有文件名
	 * 
	 * @param fileURL
	 * @return String[] 返回Excel文件名数组
	 */
	public String[] getExcelFileCollection(String fileURL) {
		File file = new File(fileURL);
		excelLists = file.list();
		return excelLists;

	}

	/**
	 * 拆分文件名，保存到数组中，分别对属性进行赋值，获得邮路名称，车牌号，时间。 去掉文件后缀名.xls
	 * 
	 * @param fileName
	 */
	public void setFileNameForCollection(String fileName) {
		this.setFileName(fileName);
		String[] nameValue = fileName.split(";");
		if (nameValue.length != 4) {
			message = fileName
					+ " 文件命名错误！******请按“邮路简称;时间yyyy-MM-dd hhmm;邮路名称;车牌号”命名！******";
			System.out.println(message);
			messageFile.message(message);
		} else {
			// 拆分字符后，分别进行赋值。
			
			this.setNamePostroadSimple(nameValue[0]);
			String nameDate = nameValue[1];
			this.setNameDateString(nameDate);
			this.setNameDate(setNameDatetoDateFormat(nameDate));
			this.setNamePostroad(nameValue[2]);
			this.setNameLicence(nameValue[3].substring(0,nameValue[3].length() - 4));
		}

	}


	/**
	 * 将字符串类型转换为Date类型
	 * String类型的日期变成Date类型的日期
	 * @param nameDate
	 * @return Date日期类型yyyy-MM-dd hhmm
	 */
	public Date setNameDatetoDateFormat(String nameDate) {
		Date date = new Date();
		try {
			date = toUtilDateFromStrDateByFormat(nameDate, "yyyy-MM-dd HHmm");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	

	/**
	 * 判断时间是否在选择的时间范围内
	 * 
	 * @param p_startDate
	 * @param p_endDate
	 * @param nameDate
	 * @return 返回boolean类型
	 */
	public boolean isPostroadBetweenTime(String p_startDate, String p_endDate,
			Date nameDate) {
		try {
			Date startDate = toUtilDateFromStrDateByFormat(p_startDate,
					"yyyy-MM-dd HHmm");
			Date endDate = toUtilDateFromStrDateByFormat(p_endDate,
					"yyyy-MM-dd HHmm");

			// 如果nameDate介于startDate和endDate之间，返回true
			if (isStartDateBeforeEndDate(nameDate, startDate)) {
				if (isStartDateBeforeEndDate(endDate, nameDate)) {
					System.out.println("邮路‘预计到达的时间’介于开始时间和结束时间之间");
					return true;
				} else {
					System.out.println("邮路‘预计到达的时间’超出结束时间");
					return false;
				}
			} else {
				System.out.println("邮路‘预计到达的时间’早于开始时间");
				return false;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("所有条件不符合");
		return false;
	}

	/**
	 * 根据邮路简称，获取配置文件时间阀值
	 * 
	 * @param namePostroadSimple
	 * @return 时间阀值timeFlag
	 */
	public int getPropertiesPostroadTime(String namePostroadSimple) {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("postroadtime.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(namePostroadSimple==null){
			return 0;
		}
		else if (p.getProperty(namePostroadSimple) == null) {
			message="配置文件不存在" + "“" + namePostroadSimple + "”"
					+ "该邮路简称，请添加进去！";
			System.out.println(message);
			messageFile.message(message);
			return 0;
		} else {
			int timeFlag = Integer.parseInt(p.getProperty(namePostroadSimple));
			return timeFlag; 
		} 

	}
	
	/**
	 * 保留方法
	 * @param aimOffice
	 * @return 序号
	 */
	public String getPropertiesAddress(String aimOffice){
		String address=null;
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("youbian.properties"); 
		Properties p = new Properties();
		try { 
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(p.getProperty(aimOffice)==null){
			message="配置文件不存在" + "“" + aimOffice + "”"
					+ "该机构代码地址，请添加进去！";
			System.out.println(message);
			messageFile.message(message);
			return "???市";
		}else{
			address=p.getProperty(aimOffice);
			return address;
		}
		
	}

	/**
	 * 邮路文件名中的‘日期时间’字段，和配置文件中‘邮路的阀值时间’进行相加。
	 * @param nameDate
	 * @param timeFlag
	 * @return 返回该邮路‘预计到达时间’。
	 */
	public Date addnameDate(Date nameDate, int timeFlag) {
		String time;
		Date newNameDate=null;
		try {
			System.out.println("时间阀值："+timeFlag);
			time = addDate(nameDate, timeFlag, Calendar.HOUR, "yyyy-MM-dd HHmm");
			System.out.println("预计到达的时间：" + time);
			newNameDate=setNameDatetoDateFormat(time);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setNewNameDate(newNameDate);
		return newNameDate;

	}
	
	/**
	 * 设置预计到达时间
	 */
	public void simpleSetNewDate(){
		addnameDate(this.getNameDate(), this
				.getPropertiesPostroadTime(this.getNamePostroadSimple()));
	}

	public static void main(String[] args) {
		String str = "JH---金华-中山(浙速物委1)---闽E12345---2014-2-23 1600.xls";
		FileFormat fileFormat = new FileFormat();
		fileFormat.setFileNameForCollection(str);
		// fileFormat.duibi();
		//String p_startDate = "2014-2-20 1650";
		//String p_endDate = "2014-2-22 1650";
		//Date date = fileFormat.setNameDatetoDateFormat("2014-2-21 1550");
		//fileFormat.isPostroadBetweenTime(p_startDate, p_endDate, date);
		
		
		fileFormat.simpleSetNewDate();
		
	}

}
