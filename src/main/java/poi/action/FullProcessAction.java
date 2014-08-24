package poi.action;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import poi.bean.FullProcessBean;
import poi.fileUitl.FileCreate;
import poi.server.ExcelReader;
import poi.server.ExcelWriter;
import poi.server.FullProcessReader;
import poi.server.FullProcessWriter;

/**
 * @description 用于处理全程跟踪信息的action
 * @author 唐东宇
 *
 */
public class FullProcessAction {
	
	/**
	 * 获得邮件封发到中山三角的封发局信息
	 */
	public void getDispatchingOfficeExcel(String filesUrl){
		FullProcessReader fpReader=null;
		FullProcessWriter fpWriter=null;
		
		FileCreate fileCreate = new FileCreate();
		
		String fileURL = filesUrl+"\\";
		
		
		
		try{
			//Excel标题
			String[] title={"邮件号码","处理站点","处理动作","处理说明"};
			//Excel保存路径
			String url = fileCreate.createFile();
			String fileUrl="";
			fileUrl = fileCreate.createFile(url, "全程跟踪") + "\\"
					+ "上行邮件封发局.xls";
			OutputStream os = new FileOutputStream(fileUrl);
			fpWriter=new FullProcessWriter(os);
			fpWriter.writeExcelTitle(title);
			
			
			// 读取Excel文件内容
			InputStream inputStream = null;
			// 保存初始Excel内容
			Map<Integer, String> content = null;
			
			//Excel中所有内容。
			FullProcessBean[] fpBeans=null;
			//Excel中根据条件筛选后的内容。
			FullProcessBean[] fpBean=null;
			
			// 保存最终结果
			Map<Integer, String> endContent = new HashMap<Integer, String>();
			
			fpReader=(FullProcessReader)new ExcelReader();
			
			//获得文件夹所有Excel
			content=fpReader.readAllExcelContent(fileURL, "ALL");
			
			fpBeans=fpWriter.getfpBeanForContent(content, fileUrl);
			
			fpBean=fpWriter.getDispatchingOfficeContent(fpBeans);
			
			endContent=fpWriter.getFullProcessResult(fpBean);
			
			fpWriter.writeExcelContent(endContent, fileUrl, "none");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
