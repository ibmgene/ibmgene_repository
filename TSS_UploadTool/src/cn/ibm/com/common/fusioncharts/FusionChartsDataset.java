package cn.ibm.com.common.fusioncharts;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FusionChartsDataset {
	
	private String seriesName; //名称
	
	private String color; //颜色
	
	private String parentYAxis; //纵坐标标示，P-主轴  S-辅轴
	
	private String numberPrefix; //数字前缀
	
	private String numberSuffix; //数字后缀
	
	private List<FusionChartsDataset> datasetList = new ArrayList<FusionChartsDataset>(); 
	
	private List<FusionChartsSet> setList = new ArrayList<FusionChartsSet>(); 
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性
	
	
	public String getNumberPrefix() {
		return numberPrefix;
	}

	public void setNumberPrefix(String numberPrefix) {
		this.numberPrefix = numberPrefix;
	}

	public String getNumberSuffix() {
		return numberSuffix;
	}

	public void setNumberSuffix(String numberSuffix) {
		this.numberSuffix = numberSuffix;
	}

	public String getParentYAxis() {
		return parentYAxis;
	}

	public void setParentYAxis(String parentYAxis) {
		this.parentYAxis = parentYAxis;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<FusionChartsSet> getSetList() {
		return setList;
	}

	public void setSetList(List<FusionChartsSet> setList) {
		this.setList = setList;
	}
	
	public void addDataset(FusionChartsDataset dataset){
		this.datasetList.add(dataset);
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

	public List<FusionChartsDataset> getDatasetList() {
		return datasetList;
	}

	public void setDatasetList(List<FusionChartsDataset> datasetList) {
		this.datasetList = datasetList;
	}
	

}
