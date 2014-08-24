package poi.bean;

/**
 * @description 全程跟踪基础类信息
 * @author 唐东宇
 *
 */
public class FullProcessBean {
	
	//邮件号码
	private String mailNum;
	
	//处理时间
	private String dealTime;
	
	//处理站点
	private String dealLocation;
	
	//处理动作——条件2、“国内出口邮件封发”
	private String dealAction;
	
	//处理说明——条件1、根据“发往广东省邮政速递物流有限公司中山三角邮件处理中心”
	private String dealState;
	
	//备注
	private String comment;

	public String getMailNum() {
		return mailNum;
	}

	public void setMailNum(String mailNum) {
		this.mailNum = mailNum;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getDealLocation() {
		return dealLocation;
	}

	public void setDealLocation(String dealLocation) {
		this.dealLocation = dealLocation;
	}

	public String getDealAction() {
		return dealAction;
	}

	public void setDealAction(String dealAction) {
		this.dealAction = dealAction;
	}

	public String getDealState() {
		return dealState;
	}

	public void setDealState(String dealState) {
		this.dealState = dealState;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString(){
		
		return "邮件号码："+this.getMailNum()+" 处理站点："+this.getDealLocation()+" 处理动作："+this.getDealAction()+" 处理说明："+this.getDealState();
	}
	

}
