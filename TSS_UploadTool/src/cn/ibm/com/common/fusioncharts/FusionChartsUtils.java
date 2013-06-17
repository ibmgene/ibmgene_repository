package cn.ibm.com.common.fusioncharts;



import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class FusionChartsUtils {
	
	
	/**
	 * 获取单分类图XML数据
	 * @param graphProperties 图表基本属性
	 * @param setList 数据列表
	 * @return
	 */
	public static String getSingleSeriesXmlData(Map<String,Object> graphProperties,List<FusionChartsSet> setList){
		StringBuffer sb = new StringBuffer();
		byte[] utf8Bom = new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
		try {
			String strXML = new String(utf8Bom,"UTF-8");
			sb.append(strXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
		sb.append("<graph ");
		if(graphProperties!=null){
			Iterator<String> it  = graphProperties.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object value = graphProperties.get(key);
				sb.append(" "+key+"=\'"+value.toString()+"\' ");
			}
		}
		sb.append(">");
		if(setList!=null){
			for(FusionChartsSet set :setList){
				sb.append("<set ");
				if(set.getValue()!=null){
					sb.append(" value=\'"+set.getValue().doubleValue()+"'");
				}
				if(set.getColor()!=null){
					sb.append(" color=\'"+set.getColor().trim()+"'");
				}
				if(set.getLink()!=null){
					sb.append(" link=\'"+set.getLink().trim()+"'");
				}
				Map<String,Object> setProperies = set.getProperties();
				if(setProperies!=null){
					Iterator<String> it  = setProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = setProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" />");
			}
		}
		
		
		
		sb.append("</graph>");
		return sb.toString();
	}
	
	
	
	/**
	 * 获取多分类及组合图XML数据
	 * @param graphProperties 图表基本属性
	 * @param categories X轴分类
	 * @param datasetList Y轴数据，包括柱图和线图数据
	 * @return
	 */
	public static String getMultiSeriesXmlData(Map<String,Object> graphProperties,FusionChartsCategories categories,List<FusionChartsDataset> datasetList){
		StringBuffer sb = new StringBuffer();
		byte[] utf8Bom = new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
		try {
			String strXML = new String(utf8Bom,"UTF-8");
			sb.append(strXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
		sb.append("<graph ");
		if(graphProperties!=null){
			Iterator<String> it  = graphProperties.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object value = graphProperties.get(key);
				sb.append(" "+key+"=\'"+value.toString()+"\' ");
			}
		}
		sb.append(">");
		if(categories!=null){
			sb.append("<categories ");
			Map<String,Object> categoriesProperies = categories.getProperties();
			if(categoriesProperies!=null){
				Iterator<String> it  = categoriesProperies.keySet().iterator();
				while(it.hasNext()){
					String key = it.next();
					Object value = categoriesProperies.get(key);
					sb.append(" "+key+"=\'"+value.toString()+"\' ");
				}
			}
			sb.append(">");
			List<FusionChartsCategory> categoryList = categories.getCategoryList();
			for(FusionChartsCategory category : categoryList){
				sb.append("<category ");
				if(category.getName()!=null){
					sb.append(" name='"+category.getName().trim()+"'");
				}
				if(category.getHoverText()!=null){
					sb.append(" hoverText='"+category.getHoverText().trim()+"'");
				}
				if(category.getShowName()!=null){
					sb.append(" showName='"+category.getShowName().intValue()+"'");
				}		
				
				Map<String,Object> categoryProperies = category.getProperties();
				if(categoryProperies!=null){
					Iterator<String> it  = categoryProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = categoryProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" />");
			}
			sb.append("</categories>");
		}
		
		if(datasetList!=null){
			for(FusionChartsDataset dataset:datasetList){
				sb.append("<dataset ");
				if(dataset.getSeriesName()!=null){
					sb.append(" seriesName='"+dataset.getSeriesName().trim()+"'");
				}
				if(dataset.getColor()!=null){
					sb.append(" color='"+dataset.getColor().trim()+"'");
				}
				if(dataset.getParentYAxis()!=null){
					sb.append(" parentYAxis='"+dataset.getParentYAxis().trim()+"'");
				}
				if(dataset.getNumberPrefix()!=null){
					sb.append(" numberPrefix='"+dataset.getNumberPrefix().trim()+"'");
				}
				if(dataset.getNumberSuffix()!=null){
					sb.append(" numberSuffix='"+dataset.getNumberSuffix().trim()+"'");
				}
				Map<String,Object> datasetProperies = dataset.getProperties();
				if(datasetProperies!=null){
					Iterator<String> it  = datasetProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = datasetProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" >");
				List<FusionChartsSet> setList =dataset.getSetList();
				if(setList!=null){
					for(FusionChartsSet set :setList){
						sb.append("<set ");
						if(set.getValue()!=null){
							sb.append(" value=\'"+set.getValue().doubleValue()+"'");
						}
						if(set.getColor()!=null){
							sb.append(" color=\'"+set.getColor().trim()+"'");
						}
						if(set.getLink()!=null){
							sb.append(" link=\'"+set.getLink().trim()+"'");
						}
						if(set.getShowValue()!=null){
							sb.append(" showValue=\'"+set.getShowValue().intValue()+"'");
						}
						Map<String,Object> setProperies = set.getProperties();
						if(setProperies!=null){
							Iterator<String> it  = setProperies.keySet().iterator();
							while(it.hasNext()){
								String key = it.next();
								Object value = setProperies.get(key);
								sb.append(" "+key+"=\'"+value.toString()+"\' ");
							}
						}
						sb.append(" />");
					}
				}
				sb.append("</dataset>");
			}
		}
		sb.append("</graph>");
		return sb.toString();
	}
	
	public static String getCandlestickXmlData(Map<String,Object> graphProperties,FusionChartsCategories categories,FusionChartsDataset dataset,FusionChartsTrendset trendset){
		StringBuffer sb = new StringBuffer();
		byte[] utf8Bom = new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
		try {
			String strXML = new String(utf8Bom,"UTF-8");
			sb.append(strXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
		sb.append("<graph ");
		if(graphProperties!=null){
			Iterator<String> it  = graphProperties.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object value = graphProperties.get(key);
				sb.append(" "+key+"=\'"+value.toString()+"\' ");
			}
		}
		sb.append(">");
		if(categories!=null){
			sb.append("<categories ");
			Map<String,Object> categoriesProperies = categories.getProperties();
			if(categoriesProperies!=null){
				Iterator<String> it  = categoriesProperies.keySet().iterator();
				while(it.hasNext()){
					String key = it.next();
					Object value = categoriesProperies.get(key);
					sb.append(" "+key+"=\'"+value.toString()+"\' ");
				}
			}
			sb.append(">");
			List<FusionChartsCategory> categoryList = categories.getCategoryList();
			for(FusionChartsCategory category : categoryList){
				sb.append("<category ");
				if(category.getName()!=null){
					sb.append(" name='"+category.getName().trim()+"'");
				}
				if(category.getHoverText()!=null){
					sb.append(" hoverText='"+category.getHoverText().trim()+"'");
				}
				if(category.getShowName()!=null){
					sb.append(" showName='"+category.getShowName().intValue()+"'");
				}		
				
				Map<String,Object> categoryProperies = category.getProperties();
				if(categoryProperies!=null){
					Iterator<String> it  = categoryProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = categoryProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" />");
			}
			sb.append("</categories>");
		}
		
		if(dataset!=null){	
				sb.append("<dataset ");
				if(dataset.getSeriesName()!=null){
					sb.append(" seriesName='"+dataset.getSeriesName().trim()+"'");
				}
				if(dataset.getColor()!=null){
					sb.append(" color='"+dataset.getColor().trim()+"'");
				}
				if(dataset.getParentYAxis()!=null){
					sb.append(" parentYAxis='"+dataset.getParentYAxis().trim()+"'");
				}
				if(dataset.getNumberPrefix()!=null){
					sb.append(" numberPrefix='"+dataset.getNumberPrefix().trim()+"'");
				}
				if(dataset.getNumberSuffix()!=null){
					sb.append(" numberSuffix='"+dataset.getNumberSuffix().trim()+"'");
				}
				Map<String,Object> datasetProperies = dataset.getProperties();
				if(datasetProperies!=null){
					Iterator<String> it  = datasetProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = datasetProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" >");
				List<FusionChartsSet> setList =dataset.getSetList();
				if(setList!=null){
					for(FusionChartsSet set :setList){
						sb.append("<set ");
						Map<String,Object> setProperies = set.getProperties();
						if(setProperies!=null){
							Iterator<String> it  = setProperies.keySet().iterator();
							while(it.hasNext()){
								String key = it.next();
								Object value = setProperies.get(key);
								sb.append(" "+key+"=\'"+value.toString()+"\' ");
							}
						}
						sb.append(" />");
					}
				}
				sb.append("</dataset>");
		}
		if(trendset!=null){	
			sb.append("<trendset ");
			if(trendset.getName()!=null){
				sb.append(" name='"+trendset.getName().trim()+"'");
			}
			if(trendset.getColor()!=null){
				sb.append(" color='"+trendset.getColor().trim()+"'");
			}
			
			Map<String,Object> trendsetProperies = trendset.getProperties();
			if(trendsetProperies!=null){
				Iterator<String> it  = trendsetProperies.keySet().iterator();
				while(it.hasNext()){
					String key = it.next();
					Object value = trendsetProperies.get(key);
					sb.append(" "+key+"=\'"+value.toString()+"\' ");
				}
			}
			sb.append(" >");
			List<FusionChartsSet> setList =dataset.getSetList();
			if(setList!=null){
				for(FusionChartsSet set :setList){
					sb.append("<set ");
					Map<String,Object> setProperies = set.getProperties();
					if(setProperies!=null){
						Iterator<String> it  = setProperies.keySet().iterator();
						while(it.hasNext()){
							String key = it.next();
							Object value = setProperies.get(key);
							sb.append(" "+key+"=\'"+value.toString()+"\' ");
						}
					}
					sb.append(" />");
				}
			}
			sb.append("</trendset>");
	}
		sb.append("</graph>");
		return sb.toString();
	}
	
	public static String getLinearXmlData(Map<String,Object> graphProperties,List<FusionChartsColor> colorList,List<FusionChartsPoint> pointList){
		StringBuffer sb = new StringBuffer();
		byte[] utf8Bom = new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
		try {
			String strXML = new String(utf8Bom,"UTF-8");
			sb.append(strXML);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
		sb.append("<graph ");
		if(graphProperties!=null){
			Iterator<String> it  = graphProperties.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object value = graphProperties.get(key);
				sb.append(" "+key+"=\'"+value.toString()+"\' ");
			}
		}
		sb.append(">");
		
		
		if(colorList!=null){
			sb.append("<colorRange>");
			for(FusionChartsColor color :colorList){
				
				sb.append("<color ");
				if(color.getMinValue()!=null){
					sb.append(" minValue=\'"+color.getMinValue().doubleValue()+"'");
				}
				if(color.getMaxValue()!=null){
					sb.append(" maxValue=\'"+color.getMaxValue().doubleValue()+"'");
				}
				if(color.getLabel()!=null){
					sb.append(" label=\'"+color.getLabel()+"'");
				}
				if(color.getCode()!=null){
					sb.append(" code=\'"+color.getCode()+"'");
				}
				
				Map<String,Object> colorProperies = color.getProperties();
				if(colorProperies!=null){
					Iterator<String> it  = colorProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = colorProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" />");
			}
			sb.append("</colorRange>");
		}
		if(pointList!=null){
			sb.append("<trendpoints>");
			for(FusionChartsPoint point :pointList){
				sb.append("<point ");
				if(point.getStartValue()!=null){
					sb.append(" startValue=\'"+point.getStartValue().doubleValue()+"'");
				}
				if(point.getEndValue()!=null){
					sb.append(" endValue=\'"+point.getEndValue().doubleValue()+"'");
				}
				if(point.getDisplayValue()!=null){
					sb.append(" displayValue=\'"+point.getDisplayValue()+"'");
				}
				if(point.getShowOnTop()!=null){
					sb.append(" showOnTop=\'"+point.getShowOnTop().intValue()+"'");
				}
				if(point.getUseMarker()!=null){
					sb.append(" useMarker=\'"+point.getUseMarker().intValue()+"'");
				}
				
				Map<String,Object> pointProperies = point.getProperties();
				if(pointProperies!=null){
					Iterator<String> it  = pointProperies.keySet().iterator();
					while(it.hasNext()){
						String key = it.next();
						Object value = pointProperies.get(key);
						sb.append(" "+key+"=\'"+value.toString()+"\' ");
					}
				}
				sb.append(" />");
			}
			sb.append("</trendpoints>");
		}
		
		
		
		sb.append("</graph>");
		return sb.toString();
	}
 
}
