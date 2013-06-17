package cn.ibm.com.common.fusioncharts;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FusionChartsTrendset {

	private String name; //名称
	
	private String color; //颜色
	
	private List<FusionChartsSet> setList = new ArrayList<FusionChartsSet>(); 
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FusionChartsSet> getSetList() {
		return setList;
	}

	public void setSetList(List<FusionChartsSet> setList) {
		this.setList = setList;
	}
	
	public void addSet(FusionChartsSet set){
		this.setList.add(set);
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
