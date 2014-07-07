package poi.bean;

/**
 * @description 基础信息类，用于保存邮件总包所有信息。
 * @author 唐东宇
 * 
 */
public class BaseBean {
	// 总包号码
	private String pack_num;
	// 原寄局
	private String source_office;
	// 寄达局
	private String aim_office;
	// 邮件种类
	private String mail_type;
	// 封发日期
	private String dispatch_date;
	// 重量
	private String weight;
	// 邮袋型号
	private String mailbag_type;
	// 备注
	private String remark;
	// 总包条码
	private String pack_bar_code;

	// 总包条码对象
	private PackObject packobject;
	
	private boolean flag;

	public String getPack_num() {
		return pack_num;
	}

	public void setPack_num(String pack_num) {
		this.pack_num = pack_num;
	}

	public String getSource_office() {
		return source_office;
	}

	public void setSource_office(String source_office) {
		this.source_office = source_office;
	}

	public String getAim_office() {
		return aim_office;
	}

	public void setAim_office(String aim_office) {
		this.aim_office = aim_office;
	}

	public String getMail_type() {
		return mail_type;
	}

	public void setMail_type(String mail_type) {
		this.mail_type = mail_type;
	}

	public String getDispatch_date() {
		return dispatch_date;
	}

	public void setDispatch_date(String dispatch_date) {
		this.dispatch_date = dispatch_date;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getMailbag_type() {
		return mailbag_type;
	}

	public void setMailbag_type(String mailbag_type) {
		this.mailbag_type = mailbag_type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPack_bar_code() {
		return pack_bar_code;
	}

	public void setPack_bar_code(String pack_bar_code) {
		this.pack_bar_code = pack_bar_code;
	}

	public PackObject getPackobject() {
		return packobject;
	}

	public void setPackobject(PackObject packobject) {
		this.packobject = packobject;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String toString() {
		return "总包号码：" + this.getPack_num() + " 原寄局：" + this.getSource_office()
				+ " 寄达局：" + this.getAim_office() + " 邮件种类："
				+ this.getMail_type() + " 总包条码：" + this.getPack_bar_code();
	}

}
