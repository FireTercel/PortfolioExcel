package poi.fileUitl;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

import date.util.DateUtil;

public class FileCreate {
	
	private static File file;
	private static DateUtil dateUtil;
	   
	public static String createFile(){ 
		dateUtil=new DateUtil(); 
		String fileurl="";
		try {
			String url=dateUtil.toStrDateFromUtilDateByFormat(new Date(),"yyyy-MM-dd");
			fileurl="D:\\导出报表\\"+url;
			file=new File(fileurl);
			if(!file.exists()){
				file.mkdirs();
			} 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return fileurl;
	}
	public static String createFile(String url,String filename){
		String fileUrl=url+"\\"+filename;
		file=new File(fileUrl);
		if(!file.exists()){
			file.mkdirs();
		}
		return fileUrl;
	}
	
	public static void main(String[] args){
		FileCreate fileCreate=new FileCreate();
		fileCreate.createFile();
	}

}
