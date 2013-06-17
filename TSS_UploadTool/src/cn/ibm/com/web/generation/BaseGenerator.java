package cn.ibm.com.web.generation;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.common.util.ConfigurationHelper;


import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 生成静态页面基础类
 * 
 * @author junl
 * 
 */
public class BaseGenerator {

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ConfigurationHelper gvipConfigurationHelper;

	private Configuration freemarker_cfg = null;

	private String template_dir;

	private String generate_base_dir;
	
	private String css_base_path;
	
	private String js_base_path;
	
	private String image_base_path;
	
	private String web_base_path;
	
	private String fusioncharts_base_path;
	
	private String generate_stock_folder;
	
	
	
	private void init(){
		if(generate_base_dir==null){
			generate_base_dir = gvipConfigurationHelper.getProperty("generate_base_dir");
		}
		if(css_base_path==null){
			css_base_path = gvipConfigurationHelper.getProperty("css_base_path");
		}
		if(js_base_path==null){
			js_base_path = gvipConfigurationHelper.getProperty("js_base_path");
		}
		if(web_base_path==null){
			web_base_path = gvipConfigurationHelper.getProperty("web_base_path");
		}
		if(fusioncharts_base_path==null){
			fusioncharts_base_path = gvipConfigurationHelper.getProperty("fusioncharts_base_path");
		}
		if(image_base_path==null){
			image_base_path = gvipConfigurationHelper.getProperty("image_base_path");
		}
		if(generate_stock_folder==null){
			generate_stock_folder = gvipConfigurationHelper.getProperty("generate_stock_folder");
		}
		
	}
	
	protected void putBaseProperties(Map propMap){
		propMap.put("css_base_path", css_base_path);
		propMap.put("js_base_path", js_base_path);
		propMap.put("web_base_path", web_base_path);
		propMap.put("fusioncharts_base_path", fusioncharts_base_path);
		propMap.put("image_base_path", image_base_path);
	}

	protected boolean geneHtmlFile(Map propMap, String templateFileName,
			String generateFileDir, String generateFileName) {
		File generatefile = null;
		Writer out = null;
		try {
			Template t = getFreemarkerCFG().getTemplate(templateFileName, "UTF-8");

			creatDirs(generate_base_dir + "/" + generateFileDir);

			generatefile = new File(generate_base_dir + "/" + generateFileDir + "/" + generateFileName);
            
			out = new OutputStreamWriter(new FileOutputStream(generatefile,false), "UTF-8");

			this.putBaseProperties(propMap);
			
			t.process(propMap, out);
		} catch (Exception e) {
			logger.error("Error while generate Static Html File "+ generateFileName, e);
			return false;
		} finally {
			if (generatefile != null) {
				generatefile = null;
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	}
	
	protected boolean geneCommonFile(String content,String generateFileDir, String generateFileName){
		File generatefile = null;
		BufferedWriter writer =null; 
		try {

			creatDirs(generate_base_dir + "/" + generateFileDir);

			generatefile = new File(generate_base_dir + "/" + generateFileDir + "/" + generateFileName);

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(generatefile,false), "UTF-8"));

			writer.write(content);
		} catch (Exception e) {
			logger.error("Error while generate Static Html File "+ generateFileName, e);
			return false;
		} finally {
			if (generatefile != null) {
				generatefile = null;
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}

	private Configuration getFreemarkerCFG() {
		if (null == freemarker_cfg) {
			freemarker_cfg = new Configuration();
			freemarker_cfg.setClassForTemplateLoading(this.getClass(),template_dir);
		}
		return freemarker_cfg;
	}

	private boolean creatDirs(String dirPath) {
		File dirFile = new File(dirPath);
		if(dirFile.exists()){
			return true;
		}else{
			return dirFile.mkdirs();
		}
	}

	public void setTemplate_dir(String template_dir) {
		this.template_dir = template_dir;
	}

	public String getGenerate_stock_folder() {
		return generate_stock_folder;
	}

	

}
