package poi.server;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import poi.bean.BaseBean;
import poi.bean.FullProcessBean;

public class FullProcessWriter extends ExcelWriter {
	
	private POIFSFileSystem fs;
	private OutputStream os;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private Map<Integer,BaseBean>  exceptionBeans;//存放异常对象集合
	
	public FullProcessWriter(){
		
	}
	
	public FullProcessWriter(OutputStream os){
		this.os = os;
		wb = new HSSFWorkbook();
	}
	
	/**
	 * 将Excel中所有内容，保存在一个数组，数组的每一个元素代表一行。
	 * @param content
	 * @param url
	 * @return 所有内容的数组。
	 */
	public FullProcessBean[] getfpBeanForContent(Map<Integer, String> content,
			String url){
		
		int rowNum = content.size();
		System.out.println("内容总行数：" + rowNum);
		// 获得总列数
		int colNum = setCellForCollection(content.get(1)).length;
		System.out.println("内容总列数：" + colNum);
		
		FullProcessBean[] fpBeans=new FullProcessBean[rowNum];
		
		for (int i = 0; i < rowNum; i++) {
			
			String info = content.get(i + 1);
			String[] infos = info.split("/");
			fpBeans[i]=new FullProcessBean();
			
			fpBeans[i].setMailNum(infos[0]);
			fpBeans[i].setDealTime(infos[1]);
			fpBeans[i].setDealLocation(infos[2]);
			fpBeans[i].setDealAction(infos[3]);
			fpBeans[i].setDealState(infos[4]);
			fpBeans[i].setComment(infos[5]);
			
		}
		
		return fpBeans;
		
	}
	
	/**
	 * 根据条件，筛选出需要的数据。
	 * @param fpBean
	 * @return 筛选后的结果
	 */
	public FullProcessBean[] getDispatchingOfficeContent(FullProcessBean[] fpBean){
		
		String conditionOne="发往广东省邮政速递物流有限公司中山三角邮件处理中心";
		String conditionTwo="国内出口邮件封发";
		FullProcessBean[] fpBeans=fpBean;
		FullProcessBean[] fpb=null;
		int index=0;
		
		for(int i=0;i<fpBeans.length;i++){
			//1、判断条件一是否成立？
			String dealState=fpBeans[i].getDealState();
			if(dealState.substring(0, 25).equals(conditionOne)){
				//2、判断条件二是否成立？
				String dealAction=fpBeans[i].getDealAction();
				if(dealAction.substring(0, 8).equals(conditionTwo)){
					fpb[index]=new FullProcessBean();
					fpb[index].setMailNum(fpBeans[i].getMailNum());
					fpb[index].setDealTime(fpBeans[i].getDealTime());
					fpb[index].setDealLocation(fpBeans[i].getDealLocation());
					fpb[index].setDealAction(fpBeans[i].getDealAction());
					fpb[index].setComment(fpBeans[i].getComment());
					
					index++;
					
				}
				
			}
			
		}
		
		return fpb;
		
	}
	
	/**
	 *  获得最终结果。
	 * @param fpBean
	 * @return 
	 */
	public Map<Integer, String> getFullProcessResult(FullProcessBean[] fpBean){
		
		FullProcessBean[] fpBeans=fpBean;
		// 保存最终结果
		Map<Integer, String> endContent = new HashMap<Integer, String>();
		// 返回结果
		String str = "";
		
		for(int i=0;i<fpBeans.length;i++){
			
			StringBuffer sbuffer = new StringBuffer();
			
			sbuffer.append(fpBeans[i].getMailNum()+"/" );
			sbuffer.append(fpBeans[i].getDealLocation()+"/");
			sbuffer.append(fpBeans[i].getDealAction()+"/");
			sbuffer.append(fpBeans[i].getDealState()+"/");
			
			String endString = sbuffer.toString();
			
			endContent.put(i + 1, endString);
			
			
		}
		
		
		return endContent;
		
	} 

}
