package cn.ibm.com.common.util;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 说明 ：
 * 作者： gaoyunz
 * 创建日期：2010-11-30
 * 最后修改日期：2010-11-30
 * 修改记录：
 */
public class PageProperty implements Serializable{
	private static final long serialVersionUID = 6963707571095588797L;
	private int npage;
	private int npagesize;
	private int nfirstindex;
	private Map<String,Object> params;
	private List<String> descs;
	private List<String> ascs;
	public int getNpage() {
		return npage;
	}
	public void setNpage(int npage) {
		this.npage = npage;
	}
	public int getNpagesize() {
		return npagesize;
	}
	public void setNpagesize(int npagesize) {
		this.npagesize = npagesize;
	}
	public int getNfirstindex() {
		return nfirstindex;
	}
	public void setNfirstindex(int nfirstindex) {
		this.nfirstindex = nfirstindex;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	public List<String> getDescs() {
		return descs;
	}
	public void setDescs(List<String> descs) {
		this.descs = descs;
	}
	public List<String> getAscs() {
		return ascs;
	}
	public void setAscs(List<String> ascs) {
		this.ascs = ascs;
	}
}
