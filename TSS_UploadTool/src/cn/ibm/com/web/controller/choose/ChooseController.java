package cn.ibm.com.web.controller.choose;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ibm.com.common.util.ConfigurationHelper;
import cn.ibm.com.common.util.Utils;
import cn.ibm.com.web.cache.FundCache;
import cn.ibm.com.web.cache.StockCache;
import cn.ibm.com.web.controller.DefaultController;


/**
 * 股票基金键盘精灵控制器层
 * @author leichen
 *
 */
@Controller
public class ChooseController extends DefaultController {
	
	@Autowired
	private StockCache stockCache;
	
	@Autowired
	private FundCache fundCache;
	@Autowired
	private ConfigurationHelper gvipConfigurationHelper;
	String url="";
	public void ChooseController(){
		url=gvipConfigurationHelper.getProperty("url_base_path");
	}
	
	
	@RequestMapping("/choose_stockindex.do")
	private String chooseStockIndex(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		String tradingcode = Utils.trim(request.getParameter("tradingcode"));
		if("".equals(tradingcode)){
			model.put("url", url+"/f9/stock/000001/stockmain.htm");
		}else{
			model.put("url", url+"/f9/stock/"+tradingcode+"/stockmain.htm");
		}
		return "F9/choose/choosestockindex";
	}
	
	@RequestMapping("/choose_stockbytradingcode.do")
	public void chooseStockByTradingcode(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		String tradingcode = Utils.trim(request.getParameter("tradingcode"));
		if("".equals(tradingcode)){
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		List<Map> stockList = stockCache.getStockListByTradingcode(tradingcode);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<stockList.size();i++){
			Map map = stockList.get(i);
			sb.append("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			if(i!=stockList.size()-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		result=sb.toString();
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/choose_stockbyword.do")
	public void chooseStockByChispelling(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		String word = Utils.trim(request.getParameter("word"));
		if("".equals(word)){
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		List<Map> stockList = stockCache.getStockListByWord(word);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<stockList.size();i++){
			Map map = stockList.get(i);
			sb.append("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			if(i!=stockList.size()-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		result=sb.toString();
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 股票搜索框
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/choose_stockbyparam.do")
	public void chooseStockByParam(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		String result = "";
		int pageNo = Integer.parseInt(request.getParameter("pageNo")) ;
    	int pageSize = 8;
    	
		String tradingcode = Utils.trim(request.getParameter("tradingcode"));
		tradingcode=URLDecoder.decode(tradingcode,"UTF-8");
		if("".equals(tradingcode)){
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		Pattern  regx = Pattern.compile("[0-9]*");
		List<Map> stockList = new ArrayList<Map>();
		if(regx.matcher(tradingcode).matches()){//股票代码
			stockList = stockCache.getStockListByTradingcode(tradingcode);
		}else{//简拼、名称
			stockList = stockCache.getStockListByWord(tradingcode);
		}
		StringBuffer sb = new StringBuffer();
		//分页构建
		List<Map> list = this.stockPageUtil(pageNo,pageSize,stockList);
		sb.append("[");
		for(int i=0;i<list.size();i++){
			Map map = list.get(i);
			//System.out.println("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			sb.append("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			if(i!=list.size()-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		result=sb.toString();
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 股票搜索框分页管理
	 */
	private List<Map> stockPageUtil(int pageNo, int pageSize, List<Map> stockList) {
		int stockListLength = stockList.size();
		if(stockListLength <= pageSize){
			return stockList;
		}else{
			int countPageNumber = 0;//总页数
			if (stockListLength % pageSize == 0){
				countPageNumber = stockListLength / pageSize;
			}else{
				countPageNumber = 1 + stockListLength / pageSize;
			}
			if(pageNo == 0){
				pageNo = countPageNumber;
			}
			if(pageNo > countPageNumber){
				return null;
			}
			int temp = (pageNo-1)*pageSize;
			if(pageNo == countPageNumber ){//最后一页
				return stockList.subList(temp, stockListLength);
			}else{
				return stockList.subList(temp, temp+pageSize);
			}
		}
	}


	@RequestMapping("/choose_fundindex.do")
	private String chooseFundIndex(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		String tradingcode = Utils.trim(request.getParameter("tradingcode"));
		if("".equals(tradingcode)){
			model.put("url", url+"/f9/fund/000001/fundmain.htm");
		}else{
			model.put("url", url+"/f9/fund/"+tradingcode+"/fundmain.htm");
		}
		return "F9/choose/choosefundindex";
	}
	
	@RequestMapping("/choose_fundbytradingcode.do")
	public void chooseFundByTradingcode(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		String tradingcode = Utils.trim(request.getParameter("tradingcode"));
		if("".equals(tradingcode)){
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		List<Map> fundList = fundCache.getFundListByTradingcode(tradingcode);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<fundList.size();i++){
			Map map = fundList.get(i);
			sb.append("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			if(i!=fundList.size()-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		result=sb.toString();
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/choose_fundbyword.do")
	public void chooseFundByChispelling(HttpServletRequest request, HttpServletResponse response){
		String result = "";
		String word = Utils.trim(request.getParameter("word"));
		if("".equals(word)){
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		List<Map> fundList = fundCache.getFundListByWord(word);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<fundList.size();i++){
			Map map = fundList.get(i);
			sb.append("{tradingcode:'"+map.get("tradingcode")+"',secuabbr:'"+map.get("secuabbr")+"',chispelling:'"+map.get("chispelling")+"'}");
			if(i!=fundList.size()-1){
				sb.append(",");
			}
		}
		
		sb.append("]");
		result=sb.toString();
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
