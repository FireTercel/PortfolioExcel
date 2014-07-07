package poi.bean;

public class PackObject {
	
	//总包号码
	private String packNum;
	//原寄局
	private String sourceOffice;
	//寄达局
	private String aimOffice;
	//重量
	private double weight; 
	  
	//构造方法
	public PackObject(){

	}
	
	public PackObject(String packNum,String sourceOffice,String aimOffice){
		this.packNum=packNum; 
		this.sourceOffice=sourceOffice;
		this.aimOffice=aimOffice;
	}
	
	public String getPackNum() {
		return packNum;
	}
	public void setPackNum(String packNum) {
		this.packNum = packNum;
	}
	public String getSourceOffice() { 
		return sourceOffice;
	}
	public void setSourceOffice(String sourceOffice) {
		this.sourceOffice = sourceOffice;
	}
	public String getAimOffice() {
		return aimOffice;
	}
	public void setAimOffice(String aimOffice) {
		this.aimOffice = aimOffice;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String toString(){
		return "总包号码："+packNum+" 原寄局："+sourceOffice+" 寄达局："+aimOffice+" 重量："+weight;
	}
	

}
