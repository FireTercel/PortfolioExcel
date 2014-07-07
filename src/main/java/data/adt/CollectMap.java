package data.adt;

import java.util.HashMap;
import java.util.Map;

import data.dao.WorkmateInitDAO;
import data.init.WorkmateInit;

/**
 * 该类用来初始化员工值，调用WorkmateInit方法dateInit()，保存到集合Map中。
 * @author 唐东宇
 *
 */ 
public class CollectMap extends HashMap{

	private Map worksMap; 
	// 建立一个接口引用，到时候调用数据库时，直接修改内部实现，不需要改变该类。
	private WorkmateInitDAO workmateInitDAO;
	//private WorkmateInit wmInit;//接口的某一个实现类

	public CollectMap() { 

	}
	public CollectMap(Map worksMap){
		this.worksMap=worksMap;
	}
	public CollectMap(Map worksMap,WorkmateInitDAO workmateInitDAO) {
		
		this.worksMap=worksMap;
		this.workmateInitDAO=workmateInitDAO;

	}
	
	public Map getWorksMap() {
		return worksMap;
	}


	public void setWorksMap(Map worksMap) {
		
		this.worksMap = worksMap;
	}


	//自己的setter，初始化对象为WorkmateInit()
	public void setWorkmateInitDAO(WorkmateInitDAO workmateInitDAO) {
		
		this.workmateInitDAO = workmateInitDAO;
	}

	public WorkmateInitDAO getWorkmateInitDAO() {
		return workmateInitDAO;
	}

	/**
	 *  开始调用，打印初始化值。
	 */
	public void MapInit() {
		worksMap = new HashMap();
		workmateInitDAO = new WorkmateInit();
		Workmates[] workmates;
		workmates = workmateInitDAO.dateInit();
		workmateInitDAO.print();
	}

	/**
	 * 给类CollectMap的worksMap属性赋值，值为类WorkmateInit初始化方法dateInit()获得。
	 * @return 返回worksMap
	 */
	public Map insertMapData() {
		worksMap = new HashMap();
		workmateInitDAO = new WorkmateInit();
		//CollectMap testCollectMap = new CollectMap();
		Workmates[] workmates;
		workmates = workmateInitDAO.dateInit();
		
		for(int i=0;i<workmates.length;i++){
			worksMap.put(i+1, workmates[i]);
		}
		

		return worksMap;
		
	}

	public static void main(String[] args) {
		CollectMap testCollectMap = new CollectMap();
		testCollectMap.insertMapData();
	}

}
