package data.init;

import data.adt.Workmates;
import data.dao.WorkmateInitDAO;


public class WorkmateInit implements WorkmateInitDAO {
	private Workmates[] workms;
	
	public Workmates[] dateInit(){
		workms=new Workmates[30]; 
		for(int i=0;i<workms.length;i++){
			if(i< 10){
				workms[i]=new Workmates("010010"+i, "林小鱼0"+i, "文件班0"+i, "14893854320"+i);
			}
			else if (i>=10){
				workms[i]=new Workmates("01001"+i, "林小鱼"+i, "文件班"+i, "1489385432"+i);
			}
			  
		} 
		return workms;
	} 
	
	public void print(){
		if(workms!=null){
			for(Workmates wms:workms){
				System.out.println(wms.getWorkID()+"\t"+wms.getName()+"\t"+wms.getStation()+"\t"+wms.getPhoneNumber()); 
			}
		}
		else 
			System.out.println("无数据！");
		
	}

}
