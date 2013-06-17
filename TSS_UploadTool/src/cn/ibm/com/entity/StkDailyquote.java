package cn.ibm.com.entity;



import java.util.Date;

/**
 * StkDailyquote.java, Created on  2010-12-05
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2010 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2010-12-05  22:32:46 
 */
public class StkDailyquote {
	
    private Long id;

    private Long secucode;

    private Date tradingday;

    private String tradingstate;

    private Double prevclosingprice;

    private Double openingprice;

    private Double highestprice;

    private Double lowestprice;

    private Double closingprice;

    private Double adjustclosingprice;

    private Double turnovervol;

    private Double turnoverval;

    private Long turnoverdeals;

    private Double daychange;

    private Double daychangerate;

    private Double turnoverrate;

    private Double amplitude;

    private Date entrytime;

    private Date updatetime;

    private Date groundtime;

    private Long updateid;

    private String resourceid;

    private String recordid;
    
    private String secuabbr;//股票简称（取于stkbasicinfo）
    private Double inxclosingprice;//指数行情的收盘
	private Double inxdaychangerate;//指数行情的涨跌幅对比
    private String inxsecuabbr;//指数简称（取于inxbasicinfo）
    private double stkcompFirstrate;//相对于第一天作比较 涨跌幅度
    private double inxcompFirstrate;//相对于第一天作比较 涨跌幅度
    
    public Double getInxclosingprice() {
		return inxclosingprice;
	}

	public void setInxclosingprice(Double inxclosingprice) {
		this.inxclosingprice = inxclosingprice;
	}

    public double getStkcompFirstrate() {
		return stkcompFirstrate;
	}

	public void setStkcompFirstrate(double stkcompFirstrate) {
		this.stkcompFirstrate = stkcompFirstrate;
	}

	public double getInxcompFirstrate() {
		return inxcompFirstrate;
	}

	public void setInxcompFirstrate(double inxcompFirstrate) {
		this.inxcompFirstrate = inxcompFirstrate;
	}
    public String getInxsecuabbr() {
		return inxsecuabbr;
	}

	public void setInxsecuabbr(String inxsecuabbr) {
		this.inxsecuabbr = inxsecuabbr;
	}


	public Double getInxdaychangerate() {
		return inxdaychangerate;
	}

	public void setInxdaychangerate(Double inxdaychangerate) {
		this.inxdaychangerate = inxdaychangerate;
	}

	public String getSecuabbr() {
		return secuabbr;
	}

	public void setSecuabbr(String secuabbr) {
		this.secuabbr = secuabbr;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSecucode() {
		return this.secucode;
	}

	public void setSecucode(Long secucode) {
		this.secucode = secucode;
	}

	public Date getTradingday() {
		return this.tradingday;
	}

	public void setTradingday(Date tradingday) {
		this.tradingday = tradingday;
	}

	public String getTradingstate() {
		return this.tradingstate;
	}

	public void setTradingstate(String tradingstate) {
		this.tradingstate = tradingstate;
	}

	public Double getPrevclosingprice() {
		return this.prevclosingprice;
	}

	public void setPrevclosingprice(Double prevclosingprice) {
		this.prevclosingprice = prevclosingprice;
	}

	public Double getOpeningprice() {
		return this.openingprice;
	}

	public void setOpeningprice(Double openingprice) {
		this.openingprice = openingprice;
	}

	public Double getHighestprice() {
		return this.highestprice;
	}

	public void setHighestprice(Double highestprice) {
		this.highestprice = highestprice;
	}

	public Double getLowestprice() {
		return this.lowestprice;
	}

	public void setLowestprice(Double lowestprice) {
		this.lowestprice = lowestprice;
	}

	public Double getClosingprice() {
		return this.closingprice;
	}

	public void setClosingprice(Double closingprice) {
		this.closingprice = closingprice;
	}

	public Double getAdjustclosingprice() {
		return this.adjustclosingprice;
	}

	public void setAdjustclosingprice(Double adjustclosingprice) {
		this.adjustclosingprice = adjustclosingprice;
	}

	public Double getTurnovervol() {
		return this.turnovervol;
	}

	public void setTurnovervol(Double turnovervol) {
		this.turnovervol = turnovervol;
	}

	public Double getTurnoverval() {
		return this.turnoverval;
	}

	public void setTurnoverval(Double turnoverval) {
		this.turnoverval = turnoverval;
	}

	public Long getTurnoverdeals() {
		return this.turnoverdeals;
	}

	public void setTurnoverdeals(Long turnoverdeals) {
		this.turnoverdeals = turnoverdeals;
	}

	public Double getDaychange() {
		return this.daychange;
	}

	public void setDaychange(Double daychange) {
		this.daychange = daychange;
	}

	public Double getDaychangerate() {
		return this.daychangerate;
	}

	public void setDaychangerate(Double daychangerate) {
		this.daychangerate = daychangerate;
	}

	public Double getTurnoverrate() {
		return this.turnoverrate;
	}

	public void setTurnoverrate(Double turnoverrate) {
		this.turnoverrate = turnoverrate;
	}

	public Double getAmplitude() {
		return this.amplitude;
	}

	public void setAmplitude(Double amplitude) {
		this.amplitude = amplitude;
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
