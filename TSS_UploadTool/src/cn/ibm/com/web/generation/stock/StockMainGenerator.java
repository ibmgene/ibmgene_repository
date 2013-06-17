package cn.ibm.com.web.generation.stock;





import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.common.constants.GaotimeConstants;
import cn.ibm.com.common.fusioncharts.FusionChartsCategories;
import cn.ibm.com.common.fusioncharts.FusionChartsCategory;
import cn.ibm.com.common.fusioncharts.FusionChartsColor;
import cn.ibm.com.common.fusioncharts.FusionChartsDataset;
import cn.ibm.com.common.fusioncharts.FusionChartsPoint;
import cn.ibm.com.common.fusioncharts.FusionChartsSet;
import cn.ibm.com.common.fusioncharts.FusionChartsUtils;
import cn.ibm.com.common.util.Utils;
import cn.ibm.com.entity.StkDailyquote;
import cn.ibm.com.kernel.service.stk.StkDailyquoteService;
import cn.ibm.com.web.generation.BaseGenerator;






public class StockMainGenerator extends BaseGenerator{
	
	private static Logger error_log = Logger.getLogger("marketerrorlog");
	
	
	
	@Autowired
	private StkDailyquoteService stkDailyquoteService;
		
	/**
	 * 生成个股全景页面
	 * @param tradingcode-交易代码
	 */
	public void generateMain(String tradingcode){	
		Map propMap  = new HashMap();
		if(tradingcode!=null&&!"".equals(tradingcode)){
			propMap.put("tradingcode", tradingcode);
			
			try{//沪深指数收益率对比
					this.setStockInfohushen(tradingcode, 0, propMap);
					this.geneHtmlFile(propMap, "stock/cominfo.tpl", this.getGenerate_stock_folder()+"/"+tradingcode, "cominfo.htm");
				
			}catch(Exception e){
				error_log.error("(个股全景)股票代码："+tradingcode+" 加载沪深指数收益率对比时发生异常");
				error_log.error(e.getMessage());
			}
			
		}
		
	}
	
	
	
	/**
	 * 获取市场表现及发行信息
	 * @param tradingcode-交易代码
	 * @param exchangecode-股市类型代码
	 * @param propMap-数据MAP
	 */
	private void setStockInfohushen(String tradingcode,int exchangecode,Map propMap){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tradingcode", tradingcode);
		String xmlName = "main_dailyQuote_hushen.xml";
		this.generateDailyQuoteChartXml(tradingcode,109,xmlName);
		propMap.put("dailyQuoteChartXmlUrl_hushen", xmlName);
	}
	
	/**
	 * 生成市场表现FLASH的XML数据文件
	 * @param tradingcode
	 * @param exchangecode
	 * @param xmlName
	 */
	private void generateDailyQuoteChartXml(String tradingcode,int exchangecode,String xmlName){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tradingcode", tradingcode);
		if(exchangecode==105){
		param.put("inxtradingcode", GaotimeConstants.SHENGZHENG_IDX_TRADINGCODE);
	    }else if(exchangecode==109){//沪深指数对比
	    	param.put("inxtradingcode", GaotimeConstants.HUSHEN_IDX_TRADINGCODE);
	    }else{
	    	param.put("inxtradingcode", GaotimeConstants.SHANGHAI_IDX_TRADINGCODE);
	    }
		List stkList=stkDailyquoteService.listStkDailyquoteBycode(param);

		List<FusionChartsCategory> categoryList = new ArrayList<FusionChartsCategory>();
		List<FusionChartsSet> setListLinestk = new ArrayList<FusionChartsSet>();
		List<FusionChartsSet> setListLineinx = new ArrayList<FusionChartsSet>();
		String stksecuabbr="";
		String inxsecuabbr="";

		double firststkData=0;
		double firstinxData=0;
		for (int i = 0; i < stkList.size(); i++) {
			StkDailyquote stkDailyquote = (StkDailyquote) stkList.get(i);
			Double closingprice=stkDailyquote.getClosingprice();
			Double inxclosingprice=stkDailyquote.getInxclosingprice();
			stksecuabbr=stkDailyquote.getSecuabbr();
			inxsecuabbr=stkDailyquote.getInxsecuabbr();
			Date tradingday=stkDailyquote.getTradingday();
					
			FusionChartsCategory category = new FusionChartsCategory();	
			category.setName(Utils.formatDate(tradingday));
			if(i==0||i==stkList.size()-1||i==stkList.size()/2){
				category.setShowName(1);
			}else{
				category.setShowName(0);
			}
			categoryList.add(category);
			FusionChartsSet setstk = new FusionChartsSet();
			FusionChartsSet setinx = new FusionChartsSet();
			if(i==0){
				firststkData=closingprice.doubleValue();
				firstinxData=inxclosingprice.doubleValue();
				setstk.setValue(new Double(0));
				setinx.setValue(new Double(0));
			}else{
				double stk=(closingprice.doubleValue()-firststkData)/firststkData*100;
				double inx=(inxclosingprice.doubleValue()-firstinxData)/firstinxData*100;
				setstk.setValue(stk);
				setinx.setValue(inx);
			}
			setListLinestk.add(setstk);
			setListLineinx.add(setinx);		
		}
			
		
	
		FusionChartsCategories categories = new FusionChartsCategories();
		if(categoryList.size()==0){
			categoryList.add(new FusionChartsCategory())
;		}
		categories.setCategoryList(categoryList);
		
		FusionChartsDataset datasetLinestk = new FusionChartsDataset();
		datasetLinestk.setColor("0066CC");
		datasetLinestk.setSeriesName(stksecuabbr);
		datasetLinestk.setSetList(setListLinestk);
		datasetLinestk.addProperties("formatNumber", 0);
		datasetLinestk.addProperties("showAnchors", 0);
		
		FusionChartsDataset datasetLineinx = new FusionChartsDataset();
		datasetLineinx.setColor("996600");
		datasetLineinx.setSeriesName(inxsecuabbr);
		datasetLineinx.setSetList(setListLineinx);
		
		List<FusionChartsDataset> datasetList = new ArrayList<FusionChartsDataset>();
		datasetList.add(datasetLinestk);
		datasetList.add(datasetLineinx);
		
		Map<String,Object> graphProperties = new HashMap<String,Object>();
		graphProperties.put("numdivlines", 4);
		graphProperties.put("showvalues", 0);
		graphProperties.put("PYAxisName","%");
		graphProperties.put("rotateYAxisName",0);
		graphProperties.put("formatNumberScale", 0);
		graphProperties.put("hoverCapSepChar", " ");
		graphProperties.put("baseFontSize", 12);
		graphProperties.put("decimals", 2);
		graphProperties.put("numberSuffix", "%25");
		graphProperties.put("drawAnchors", 0);
		graphProperties.put("canvasBorderThickness", 0);
		graphProperties.put("bgColor", "FFFFFF");
		graphProperties.put("showBorder", "0");
		graphProperties.put("borderThickness", "0");
		graphProperties.put("chartLeftMargin", "0");
		graphProperties.put("chartRightMargin", "40");
		graphProperties.put("lineThickness", "3");
		
		String content = FusionChartsUtils.getMultiSeriesXmlData(graphProperties, categories, datasetList);
		this.geneCommonFile(content, this.getGenerate_stock_folder()+"/"+tradingcode, xmlName);
	}
	
}
