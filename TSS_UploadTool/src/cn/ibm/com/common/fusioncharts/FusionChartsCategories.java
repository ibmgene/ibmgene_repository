package cn.ibm.com.common.fusioncharts;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FusionChartsCategories {
	
	private List<FusionChartsCategory> categoryList = new ArrayList<FusionChartsCategory>();
	
	private Map<String,Object> properties = new HashMap<String,Object>(); //其他属性
	
	public List<FusionChartsCategory> getCategoryList() {
		return categoryList;
	}


	public void setCategoryList(List<FusionChartsCategory> categoryList) {
		this.categoryList = categoryList;
	}


	public void addCategory(FusionChartsCategory category){
		this.categoryList.add(category);
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
