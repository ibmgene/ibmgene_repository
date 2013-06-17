package cn.ibm.com.common.util;



import java.util.*;
/**
 * 
 * @Class : ReadConfig.java
 * @author: stephen
 * @Time  :
 */
public class ReadConfig {
	
	  private static ResourceBundle properties;
	  public ReadConfig(int index) {
	    if (properties == null) {
	      initConfig(index);
	    }
	  }

	  /**
	   * 初始化配置文件信息
	   */
	  static private void initConfig(int index) {
	    try {
	         //system.properties
	    	if(index==1){
	    		 properties = ResourceBundle.getBundle("com.gaotime.vip.resource.config_message",
		                 Locale.getDefault());
	    	}else if(index==2){
	    		 properties = ResourceBundle.getBundle("com.gaotime.vip.resource.config_message",
		                 Locale.getDefault());
	    	}
	    	
	    }
	    catch (MissingResourceException e) {
	      e.printStackTrace();
	    }
	  }

	  /**
	   * 根据键值获取配置文件对应的值。
	   * @param String strKey 键值
	   * @return String 配置文件对应的 ֵ
	   */
	  static public String getConfigInfo(String strKey,int index) {
		  String str = null;
			if(strKey!=null){
			if (properties == null) {
			   initConfig(index);
			}
			  str = properties.getString(strKey);
			}
			return str == null ? "" : str;
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.out.println(ReadConfig.getConfigInfo("gatcj",1));
	}
	
	

}
