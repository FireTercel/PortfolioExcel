package data.adt;

/**
 *  员工属性
 */
public class Workmates{
	public int count;
	private String account;//账号 
	private String password;//密码
	private String workID;//工号
	private String name;//姓名
	private String station;//岗位
	private String phoneNumber;//联系方式
	private String introduce;//介绍 
	 
	public Workmates(){

	} 
	
	public Workmates(String workID,String name,String station,String phoneNumber){
		this.workID=workID;
		this.name=name;
		this.station=station;
		this.phoneNumber =phoneNumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String toString(){
		return " 账号："+account
				+" 密码："+password
				+" 工号："+workID
				+" 姓名："+name
				+" 岗位："+station
				+" 联系方式："+phoneNumber
				+" 介绍:"+introduce;
	}

}
