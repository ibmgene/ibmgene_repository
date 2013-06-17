package cn.ibm.com.common.fusioncharts;



import java.util.HashMap;
import java.util.Map;

public class FusionChartsPoint {
	
	private Double startValue;  //开始值
	
	private Double endValue;  //结束值
	
	private String displayValue;  //显示内文字内容
	
	private Integer showOnTop;  //是否显示在上部
	
	private Integer useMarker; //是否标记
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性

	public Double getStartValue() {
		return startValue;
	}

	public void setStartValue(Double startValue) {
		this.startValue = startValue;
	}

	public Double getEndValue() {
		return endValue;
	}

	public void setEndValue(Double endValue) {
		this.endValue = endValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public Integer getShowOnTop() {
		return showOnTop;
	}

	public void setShowOnTop(Integer showOnTop) {
		this.showOnTop = showOnTop;
	}

	public Integer getUseMarker() {
		return useMarker;
	}

	public void setUseMarker(Integer useMarker) {
		this.useMarker = useMarker;
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
