package cn.ibm.com.common.fusioncharts;



import java.util.HashMap;
import java.util.Map;

public class FusionChartsColor {
	
	private Double minValue; //最小值
	
	private Double maxValue; //最大值
	
	private String code;  //颜色代码
	
	private String label;  //显示文字
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
