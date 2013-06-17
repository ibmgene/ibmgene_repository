package cn.ibm.com.common.fusioncharts;



import java.util.HashMap;
import java.util.Map;

public class FusionChartsCategory {
	
	private String name;  //名称
	
	private String hoverText;  //鼠标悬停时显示的文字
	
	private Integer showName;  //是否显示名称 1-显示 0-不显示
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHoverText() {
		return hoverText;
	}

	public void setHoverText(String hoverText) {
		this.hoverText = hoverText;
	}
	
	public Integer getShowName() {
		return showName;
	}

	public void setShowName(Integer showName) {
		this.showName = showName;
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
