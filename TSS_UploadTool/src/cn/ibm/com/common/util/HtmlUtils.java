package cn.ibm.com.common.util;



import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class HtmlUtils {
	
	public static String replaceHtmlBase(String content){
		if(content!=null){
			content = content.replaceAll(" ", "&nbsp;");
			content = content.replaceAll("\r\n", "<br>");
		}
		return content;
	}
	/**
	 * TEXT 转换长HTML
	 * 
	 * @param name
	 * @return
	 */
	public static String text2Html(String text) {
		if (text != null) {
			String htmlText = text.replaceAll("\r\n", "\n");
			htmlText = htmlText.replaceAll("\n", "<br>\n");
			htmlText = htmlText.replaceAll(" ", "&nbsp;&nbsp;");
			htmlText = htmlText.replaceAll("\t", "&nbsp;&nbsp;&nbsp;\t");
			return htmlText;
		} else {
			return null;
		}
	}

	/**
	 * TEXT 转换长HTML
	 * 
	 * @param name
	 * @return
	 */
	public static String html2Text(String text) {
		if (text != null) {
			String htmlText = text.replaceAll("\n", "\r\n");
			htmlText = htmlText.replaceAll("<br>", "\r\n");
			htmlText = htmlText.replaceAll("&nbsp;&nbsp;", " ");
			htmlText = htmlText.replaceAll("&nbsp;&nbsp;&nbsp;\t", "\t");
			return htmlText;
		} else {
			return null;
		}
	}

	/**
	 * CLOB 类型字段值转换成String;
	 */
	public static String getText(Clob clob) throws SQLException {
		String s1 = "";
		char ac[] = new char[200];
		if (clob == null)
			return null;
		Reader reader = clob.getCharacterStream();
		int i;
		try {
			while ((i = reader.read(ac, 0, 200)) != -1)
				s1 = s1 + new String(ac, 0, i);
		} catch (Exception exception1) {
			throw new SQLException(exception1.getMessage());
		} finally {
			try {
				reader.close();
			} catch (Exception _ex) {
			}
		}
		return text2Html(s1);
	}
	/**
	    * 取字符串的前tocount个字符
	    * @param str 被处理字符串
	    * @param tocount 截取长度
	    * @param more 后缀字符串
	    * 截取出来绝对不会有半个的字，如你要保留7位，汉字是占2位的，
	    * 当第7位是一汉字的时候，他会把这个汉字完整的显示出来
	    */
	   public static String substring(String str,String num,String more){
		   
		  int tocount = Integer.parseInt(num);
	      int reint = 0;
	      String restr = "";
	      if (str==null)return "";
	      char[] tempchar =str.toCharArray();
	      for (int kk = 0; (kk < tempchar.length && tocount > reint); kk++) {
	        String s1 = str.valueOf(tempchar[kk]);
	        byte[] b = s1.getBytes();
	        reint += b.length;
	        restr += tempchar[kk];
	      }
	      if(str.trim().getBytes().length==tocount)return restr;
	      if (tocount == reint || (tocount == reint - 1))
	        restr += more;
	      return restr;
	   }
	   /**
	    * 去掉标题中的空格键
	    * @param str 要处理的标题
	    * @return 处理好的标题
	    */
	   public static String removeKG(String str){
		   //System.out.println(str);
		   String str2 = str.replaceAll("&nbsp;&nbsp;"," "); //去空格后的字符串
	       return str2;
	   }
}
