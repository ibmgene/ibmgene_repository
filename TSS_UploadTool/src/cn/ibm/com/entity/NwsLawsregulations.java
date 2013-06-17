package cn.ibm.com.entity;



import java.util.Date;

import cn.ibm.com.common.util.HtmlUtils;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class NwsLawsregulations {
	
    private Long id;

    private Date pubdate;

    private String infosource;

    private String title;

    private Date effedate;

    private String issueorgname;

    private String exchangename;

    private String breedname;

    private String lawname;

    private String keywords;

    private String content;
    private String contents;//格式化内容

    

	private String isvalid;

    private Date disusedate;

    private String disusereason;

    private Long importantlevel;

    private String versionnum;

    private String remark;

    private String lasttitle;

    private Date entrytime;

    private Date updatetime;

    private Date groundtime;

    private Long updateid;

    private String resourceid;

    private String recordid;



	public void setContents(String contents) {
		this.contents = contents;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getInfosource() {
		return this.infosource;
	}

	public void setInfosource(String infosource) {
		this.infosource = infosource;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEffedate() {
		return this.effedate;
	}

	public void setEffedate(Date effedate) {
		this.effedate = effedate;
	}

	public String getIssueorgname() {
		return this.issueorgname;
	}

	public void setIssueorgname(String issueorgname) {
		this.issueorgname = issueorgname;
	}

	public String getExchangename() {
		return this.exchangename;
	}

	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}

	public String getBreedname() {
		return this.breedname;
	}

	public void setBreedname(String breedname) {
		this.breedname = breedname;
	}

	public String getLawname() {
		return this.lawname;
	}

	public void setLawname(String lawname) {
		this.lawname = lawname;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getContent() {
		return this.content;
	}
	public String getContents() {
    	return HtmlUtils.text2Html(this.content);
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getIsvalid() {
		return this.isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public Date getDisusedate() {
		return this.disusedate;
	}

	public void setDisusedate(Date disusedate) {
		this.disusedate = disusedate;
	}

	public String getDisusereason() {
		return this.disusereason;
	}

	public void setDisusereason(String disusereason) {
		this.disusereason = disusereason;
	}

	public Long getImportantlevel() {
		return this.importantlevel;
	}

	public void setImportantlevel(Long importantlevel) {
		this.importantlevel = importantlevel;
	}

	public String getVersionnum() {
		return this.versionnum;
	}

	public void setVersionnum(String versionnum) {
		this.versionnum = versionnum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLasttitle() {
		return this.lasttitle;
	}

	public void setLasttitle(String lasttitle) {
		this.lasttitle = lasttitle;
	}

	public Date getEntrytime() {
		return this.entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getGroundtime() {
		return this.groundtime;
	}

	public void setGroundtime(Date groundtime) {
		this.groundtime = groundtime;
	}

	public Long getUpdateid() {
		return this.updateid;
	}

	public void setUpdateid(Long updateid) {
		this.updateid = updateid;
	}

	public String getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getRecordid() {
		return this.recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

}
