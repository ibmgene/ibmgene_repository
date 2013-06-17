package cn.ibm.com.entity;



import java.util.Date;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class FndBasicinfo {
	
    private Long id;

    private Long secucode;
    
    private String gacode;

	private Long managementcomcode;

    private String managementcom;

    private Long custodiancode;

    private String custodian;

    private String frontcode;

    private String backcode;

    private String tradingcode;

    private String secuabbr;

    private String chiname;

    private String chinameabbr;

    private String engname;

    private String engnameabbr;

    private Long secucategorycodei;

    private Long secucategorycodeii;

    private String secucategory;

    private Long exchangecode;

    private String exchangename;

    private Date listingdate;

    private Date delistingdate;

    private Long boardcode;

    private String boardname;

    private Long listingstatecode;

    private Long currencycode;

    private String isin;

    private String isexchange;

    private String isotc;

    private Long fundnature;

    private Long operationtype;

    private Long fundtypecom;

    private Long fundtypeself;

    private Long fundtypems;

    private Long fundtypecs;

    private Double issuevol;

    private Double newestvol;

    private Double parval;

    private String purchasestate;
    private String purchasestates;

    private String redemptionstate;
    private String redemptionstates;

	private String invobjective;

    private String invscope;

    private String invstrategy;

    private String benchmark;

    private String invrestriction;

    private Double duration;

    private Date durationstartdate;

    private Date durationenddate;

    private Date contracteffectdate;
    private String contracteffectdates;

	private String riskreturnfeature;

    private String returndistribution;

    private String fundmanager;

    private String isguaranteed;

    private Date guaranteedstartdate;

    private Date guaranteedenddate;

    private String isclosedendduration;

    private Date closedstartdate;

    private Date closedenddate;

    private String fundintro;

    private String marketrisk;

    private String managementrisk;

    private String liquidityrisk;

    private String invstrategyrisk;

    private String tradingrisk;

    private String otherrisk;

    private Double managementfee;

    private Double trusteeshipfee;

    private Date entrytime;

    private Date updatetime;

    private Date groundtime;

    private Long updateid;

    private String resourceid;

    private String recordid;

    private Long fundmaincode;

    private String iscombine;

    private Long indexinvtype;

    private Long indexinvobject;

    private Long fndhierarchicalpattern;

    private Long fndlevel;

    private Long etfconnectprimaryfnd;

    private Long fndumbrellaseries;

    private Long carryforwardtype;

    private Long investcharacter;

    private Long returntype;

    private Long isgetachivementreward;

    private Long fewestredemvol;

    private Long fewestholdvol;

    private Date contracteffectannouncedate;

    private Double durationdays;

    private Double listedvol;

    private Double firstlistedvol;

    private String url;

    private Date durationenddatebeforechange;
    
    private Double shareending;//基金份额变化（份）FND_ShareChange
    
    private Date issuestartdate; //认购起始日 FND_Issue
    
    private Date issueenddate; //认购终止日FND_Issue
    
    private Double fsubscriptionotcp;//场外个人单笔最低认购金额（元）  FND_Issue
    
    
    
	public Double getFsubscriptionotcp() {
		return fsubscriptionotcp;
	}

	public void setFsubscriptionotcp(Double fsubscriptionotcp) {
		this.fsubscriptionotcp = fsubscriptionotcp;
	}

	

	public String getPurchasestates() {
		if(Integer.parseInt(purchasestate) == 1){
			purchasestates="开放";
		}else{
			purchasestates="禁止";
		}
		return this.purchasestates;
	}


	public void setPurchasestates(String purchasestates) {
		this.purchasestates = purchasestates;
	}
	
	public String getRedemptionstates() {
		if(Integer.parseInt(redemptionstate) == 1){
			redemptionstates="开放";
		}else{
			redemptionstates="禁止";
		}
		return this.redemptionstates;
	}


	public void setRedemptionstates(String redemptionstates) {
		this.redemptionstates = redemptionstates;
	}


	public void setContracteffectdates(String contracteffectdates) {
		this.contracteffectdates = contracteffectdates;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	 public String getGacode() {
			return gacode;
	}

	public void setGacode(String gacode) {
			this.gacode = gacode;
	}
		
	public Long getSecucode() {
		return this.secucode;
	}

	public void setSecucode(Long secucode) {
		this.secucode = secucode;
	}

	public Long getManagementcomcode() {
		return this.managementcomcode;
	}

	public void setManagementcomcode(Long managementcomcode) {
		this.managementcomcode = managementcomcode;
	}

	public String getManagementcom() {
		return this.managementcom;
	}

	public void setManagementcom(String managementcom) {
		this.managementcom = managementcom;
	}

	public Long getCustodiancode() {
		return this.custodiancode;
	}

	public void setCustodiancode(Long custodiancode) {
		this.custodiancode = custodiancode;
	}

	public String getCustodian() {
		return this.custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}

	public String getFrontcode() {
		return this.frontcode;
	}

	public void setFrontcode(String frontcode) {
		this.frontcode = frontcode;
	}

	public String getBackcode() {
		return this.backcode;
	}

	public void setBackcode(String backcode) {
		this.backcode = backcode;
	}

	public String getTradingcode() {
		return this.tradingcode;
	}

	public void setTradingcode(String tradingcode) {
		this.tradingcode = tradingcode;
	}

	public String getSecuabbr() {
		return this.secuabbr;
	}

	public void setSecuabbr(String secuabbr) {
		this.secuabbr = secuabbr;
	}

	public String getChiname() {
		return this.chiname;
	}

	public void setChiname(String chiname) {
		this.chiname = chiname;
	}

	public String getChinameabbr() {
		return this.chinameabbr;
	}

	public void setChinameabbr(String chinameabbr) {
		this.chinameabbr = chinameabbr;
	}

	public String getEngname() {
		return this.engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public String getEngnameabbr() {
		return this.engnameabbr;
	}

	public void setEngnameabbr(String engnameabbr) {
		this.engnameabbr = engnameabbr;
	}

	public Long getSecucategorycodei() {
		return this.secucategorycodei;
	}

	public void setSecucategorycodei(Long secucategorycodei) {
		this.secucategorycodei = secucategorycodei;
	}

	public Long getSecucategorycodeii() {
		return this.secucategorycodeii;
	}

	public void setSecucategorycodeii(Long secucategorycodeii) {
		this.secucategorycodeii = secucategorycodeii;
	}

	public String getSecucategory() {
		return this.secucategory;
	}

	public void setSecucategory(String secucategory) {
		this.secucategory = secucategory;
	}

	public Long getExchangecode() {
		return this.exchangecode;
	}

	public void setExchangecode(Long exchangecode) {
		this.exchangecode = exchangecode;
	}

	public String getExchangename() {
		return this.exchangename;
	}

	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}

	public Date getListingdate() {
		return this.listingdate;
	}

	public void setListingdate(Date listingdate) {
		this.listingdate = listingdate;
	}

	public Date getDelistingdate() {
		return this.delistingdate;
	}

	public void setDelistingdate(Date delistingdate) {
		this.delistingdate = delistingdate;
	}

	public Long getBoardcode() {
		return this.boardcode;
	}

	public void setBoardcode(Long boardcode) {
		this.boardcode = boardcode;
	}

	public String getBoardname() {
		return this.boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public Long getListingstatecode() {
		return this.listingstatecode;
	}

	public void setListingstatecode(Long listingstatecode) {
		this.listingstatecode = listingstatecode;
	}

	public Long getCurrencycode() {
		return this.currencycode;
	}

	public void setCurrencycode(Long currencycode) {
		this.currencycode = currencycode;
	}

	public String getIsin() {
		return this.isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getIsexchange() {
		return this.isexchange;
	}

	public void setIsexchange(String isexchange) {
		this.isexchange = isexchange;
	}

	public String getIsotc() {
		return this.isotc;
	}

	public void setIsotc(String isotc) {
		this.isotc = isotc;
	}

	public Long getFundnature() {
		return this.fundnature;
	}

	public void setFundnature(Long fundnature) {
		this.fundnature = fundnature;
	}

	public Long getOperationtype() {
		return this.operationtype;
	}

	public void setOperationtype(Long operationtype) {
		this.operationtype = operationtype;
	}

	public Long getFundtypecom() {
		return this.fundtypecom;
	}

	public void setFundtypecom(Long fundtypecom) {
		this.fundtypecom = fundtypecom;
	}

	public Long getFundtypeself() {
		return this.fundtypeself;
	}

	public void setFundtypeself(Long fundtypeself) {
		this.fundtypeself = fundtypeself;
	}

	public Long getFundtypems() {
		return this.fundtypems;
	}

	public void setFundtypems(Long fundtypems) {
		this.fundtypems = fundtypems;
	}

	public Long getFundtypecs() {
		return this.fundtypecs;
	}

	public void setFundtypecs(Long fundtypecs) {
		this.fundtypecs = fundtypecs;
	}

	public Double getIssuevol() {
		return this.issuevol;
	}

	public void setIssuevol(Double issuevol) {
		this.issuevol = issuevol;
	}

	public Double getNewestvol() {
		return this.newestvol;
	}

	public void setNewestvol(Double newestvol) {
		this.newestvol = newestvol;
	}

	public Double getParval() {
		return this.parval;
	}

	public void setParval(Double parval) {
		this.parval = parval;
	}

	public String getPurchasestate() {
		return this.purchasestate;
	}

	public void setPurchasestate(String purchasestate) {
		this.purchasestate = purchasestate;
	}

	public String getRedemptionstate() {
		return this.redemptionstate;
	}

	public void setRedemptionstate(String redemptionstate) {
		this.redemptionstate = redemptionstate;
	}

	public String getInvobjective() {
		return this.invobjective;
	}

	public void setInvobjective(String invobjective) {
		this.invobjective = invobjective;
	}

	public String getInvscope() {
		return this.invscope;
	}

	public void setInvscope(String invscope) {
		this.invscope = invscope;
	}

	public String getInvstrategy() {
		return this.invstrategy;
	}

	public void setInvstrategy(String invstrategy) {
		this.invstrategy = invstrategy;
	}

	public String getBenchmark() {
		return this.benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public String getInvrestriction() {
		return this.invrestriction;
	}

	public void setInvrestriction(String invrestriction) {
		this.invrestriction = invrestriction;
	}

	public Double getDuration() {
		return this.duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Date getDurationstartdate() {
		return this.durationstartdate;
	}

	public void setDurationstartdate(Date durationstartdate) {
		this.durationstartdate = durationstartdate;
	}

	public Date getDurationenddate() {
		return this.durationenddate;
	}

	public void setDurationenddate(Date durationenddate) {
		this.durationenddate = durationenddate;
	}

	public Date getContracteffectdate() {
		return this.contracteffectdate;
	}

	public void setContracteffectdate(Date contracteffectdate) {
		this.contracteffectdate = contracteffectdate;
	}

	public String getRiskreturnfeature() {
		return this.riskreturnfeature;
	}

	public void setRiskreturnfeature(String riskreturnfeature) {
		this.riskreturnfeature = riskreturnfeature;
	}

	public String getReturndistribution() {
		return this.returndistribution;
	}

	public void setReturndistribution(String returndistribution) {
		this.returndistribution = returndistribution;
	}

	public String getFundmanager() {
		return this.fundmanager;
	}

	public void setFundmanager(String fundmanager) {
		this.fundmanager = fundmanager;
	}

	public String getIsguaranteed() {
		return this.isguaranteed;
	}

	public void setIsguaranteed(String isguaranteed) {
		this.isguaranteed = isguaranteed;
	}

	public Date getGuaranteedstartdate() {
		return this.guaranteedstartdate;
	}

	public void setGuaranteedstartdate(Date guaranteedstartdate) {
		this.guaranteedstartdate = guaranteedstartdate;
	}

	public Date getGuaranteedenddate() {
		return this.guaranteedenddate;
	}

	public void setGuaranteedenddate(Date guaranteedenddate) {
		this.guaranteedenddate = guaranteedenddate;
	}

	public String getIsclosedendduration() {
		return this.isclosedendduration;
	}

	public void setIsclosedendduration(String isclosedendduration) {
		this.isclosedendduration = isclosedendduration;
	}

	public Date getClosedstartdate() {
		return this.closedstartdate;
	}

	public void setClosedstartdate(Date closedstartdate) {
		this.closedstartdate = closedstartdate;
	}

	public Date getClosedenddate() {
		return this.closedenddate;
	}

	public void setClosedenddate(Date closedenddate) {
		this.closedenddate = closedenddate;
	}

	public String getFundintro() {
		return this.fundintro;
	}

	public void setFundintro(String fundintro) {
		this.fundintro = fundintro;
	}

	public String getMarketrisk() {
		return this.marketrisk;
	}

	public void setMarketrisk(String marketrisk) {
		this.marketrisk = marketrisk;
	}

	public String getManagementrisk() {
		return this.managementrisk;
	}

	public void setManagementrisk(String managementrisk) {
		this.managementrisk = managementrisk;
	}

	public String getLiquidityrisk() {
		return this.liquidityrisk;
	}

	public void setLiquidityrisk(String liquidityrisk) {
		this.liquidityrisk = liquidityrisk;
	}

	public String getInvstrategyrisk() {
		return this.invstrategyrisk;
	}

	public void setInvstrategyrisk(String invstrategyrisk) {
		this.invstrategyrisk = invstrategyrisk;
	}

	public String getTradingrisk() {
		return this.tradingrisk;
	}

	public void setTradingrisk(String tradingrisk) {
		this.tradingrisk = tradingrisk;
	}

	public String getOtherrisk() {
		return this.otherrisk;
	}

	public void setOtherrisk(String otherrisk) {
		this.otherrisk = otherrisk;
	}

	public Double getManagementfee() {
		return this.managementfee;
	}

	public void setManagementfee(Double managementfee) {
		this.managementfee = managementfee;
	}

	public Double getTrusteeshipfee() {
		return this.trusteeshipfee;
	}

	public void setTrusteeshipfee(Double trusteeshipfee) {
		this.trusteeshipfee = trusteeshipfee;
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

	public Long getFundmaincode() {
		return this.fundmaincode;
	}

	public void setFundmaincode(Long fundmaincode) {
		this.fundmaincode = fundmaincode;
	}

	public String getIscombine() {
		return this.iscombine;
	}

	public void setIscombine(String iscombine) {
		this.iscombine = iscombine;
	}

	public Long getIndexinvtype() {
		return this.indexinvtype;
	}

	public void setIndexinvtype(Long indexinvtype) {
		this.indexinvtype = indexinvtype;
	}

	public Long getIndexinvobject() {
		return this.indexinvobject;
	}

	public void setIndexinvobject(Long indexinvobject) {
		this.indexinvobject = indexinvobject;
	}

	public Long getFndhierarchicalpattern() {
		return this.fndhierarchicalpattern;
	}

	public void setFndhierarchicalpattern(Long fndhierarchicalpattern) {
		this.fndhierarchicalpattern = fndhierarchicalpattern;
	}

	public Long getFndlevel() {
		return this.fndlevel;
	}

	public void setFndlevel(Long fndlevel) {
		this.fndlevel = fndlevel;
	}

	public Long getEtfconnectprimaryfnd() {
		return this.etfconnectprimaryfnd;
	}

	public void setEtfconnectprimaryfnd(Long etfconnectprimaryfnd) {
		this.etfconnectprimaryfnd = etfconnectprimaryfnd;
	}

	public Long getFndumbrellaseries() {
		return this.fndumbrellaseries;
	}

	public void setFndumbrellaseries(Long fndumbrellaseries) {
		this.fndumbrellaseries = fndumbrellaseries;
	}

	public Long getCarryforwardtype() {
		return this.carryforwardtype;
	}

	public void setCarryforwardtype(Long carryforwardtype) {
		this.carryforwardtype = carryforwardtype;
	}

	public Long getInvestcharacter() {
		return this.investcharacter;
	}

	public void setInvestcharacter(Long investcharacter) {
		this.investcharacter = investcharacter;
	}

	public Long getReturntype() {
		return this.returntype;
	}

	public void setReturntype(Long returntype) {
		this.returntype = returntype;
	}

	public Long getIsgetachivementreward() {
		return this.isgetachivementreward;
	}

	public void setIsgetachivementreward(Long isgetachivementreward) {
		this.isgetachivementreward = isgetachivementreward;
	}

	public Long getFewestredemvol() {
		return this.fewestredemvol;
	}

	public void setFewestredemvol(Long fewestredemvol) {
		this.fewestredemvol = fewestredemvol;
	}

	public Long getFewestholdvol() {
		return this.fewestholdvol;
	}

	public void setFewestholdvol(Long fewestholdvol) {
		this.fewestholdvol = fewestholdvol;
	}

	public Date getContracteffectannouncedate() {
		return this.contracteffectannouncedate;
	}

	public void setContracteffectannouncedate(Date contracteffectannouncedate) {
		this.contracteffectannouncedate = contracteffectannouncedate;
	}

	public Double getDurationdays() {
		return this.durationdays;
	}

	public void setDurationdays(Double durationdays) {
		this.durationdays = durationdays;
	}

	public Double getListedvol() {
		return this.listedvol;
	}

	public void setListedvol(Double listedvol) {
		this.listedvol = listedvol;
	}

	public Double getFirstlistedvol() {
		return this.firstlistedvol;
	}

	public void setFirstlistedvol(Double firstlistedvol) {
		this.firstlistedvol = firstlistedvol;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDurationenddatebeforechange() {
		return this.durationenddatebeforechange;
	}

	public void setDurationenddatebeforechange(Date durationenddatebeforechange) {
		this.durationenddatebeforechange = durationenddatebeforechange;
	}
	
	public Double getShareending() {
		return shareending;
	}

	public void setShareending(Double shareending) {
		this.shareending = shareending;
	}
	
	public Date getIssuestartdate() {
		return issuestartdate;
	}


	public void setIssuestartdate(Date issuestartdate) {
		this.issuestartdate = issuestartdate;
	}


	public Date getIssueenddate() {
		return issueenddate;
	}


	public void setIssueenddate(Date issueenddate) {
		this.issueenddate = issueenddate;
	}


}
