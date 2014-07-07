package poi.bean;

public enum TranferRe {
	
	CHANG_SHA("长沙",1),	
	WU_XI("无锡",2),
	HANG_ZHOU("杭州",3),
	CHENG_DU("成都",4),
	JI_NAN("济南",5),
	KUN_MING("昆明",6),
	XI_AN("西安",7),
	WU_HAN("武汉",8),
	ZHENG_ZHOU("郑州",9),
	NAN_CHANG("南昌",10),
	NAN_NING("南宁",11),
	GUI_YANG("贵阳",12),
	FU_ZHOU("福州",13),
	HAI_KOU("海口",14),
	TANG_XI1("棠溪1",15),
	TANG_XI2("棠溪2",16),
	SAN_JIAO("三角中心",17),
	WEI_ZHI("未知",18);
	
	private String name;
	private int index;
	private TranferRe(String name,int index){
		this.name=name;
		this.index=index;
	}
	
	public static String getName(int index){
		for (TranferRe tranfer : TranferRe.values()) {
			if(tranfer.index==index){
				return tranfer.name;
			}
		}
		return null;
	}
	
	public String toString(){
		return this.name+"："+this.index;
	}
	
	public String getInfo(){
		return this.name;
	}

}
