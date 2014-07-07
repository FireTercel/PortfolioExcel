package poi.bean;
 
/**
 * @description 保存总包条码，拆开后的信息。
 * @author 唐东宇
 *
 */
public class CodeTree {
	private String nodeName;
	private String[] subNames;
	
	private int count;
	private double weights;
	
	public String getNodeName() { 
		return nodeName;
	} 
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	} 
	public String[] getSubNames() { 
		return subNames; 
	}
	public void setSubNames(String[] subNames) {
		this.subNames = subNames;
	}
	public int getCount() {
		return count; 
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getWeights() {
		return weights;
	}
	public void setWeights(double weights) {
		this.weights = weights;
	}
	
	public String toString(){
		return "省份："+this.getNodeName()+" 	数量："+this.getCount()+" 	重量："+this.getWeights();
	}
	
	

}
