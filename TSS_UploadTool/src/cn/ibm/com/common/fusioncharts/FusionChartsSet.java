package cn.ibm.com.common.fusioncharts;



import java.util.HashMap;
import java.util.Map;

public class FusionChartsSet {
	
	private Double value; //数值
	
	private String color; //颜色
	
	private Integer showValue; //是否显示数值
	
	private String link; //点击后跳转的链接地址
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性
	
	public Integer getShowValue() {
		return showValue;
	}

	public void setShowValue(Integer showValue) {
		this.showValue = showValue;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void addProperties(String name,Object value){
		this.properties.put(name, value);
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
	

}
