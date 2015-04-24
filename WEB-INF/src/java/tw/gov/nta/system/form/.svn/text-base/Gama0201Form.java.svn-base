package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.NationRef;

public class Gama0201Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	NationDebitMain nationDebitMain = new NationDebitMain ();
	private String qryAccountYear;
	private Integer qryNationCode;
	private Integer nationRefId;

	public BigDecimal getNopayAmount() {
		return nationDebitMain.getNopayAmount();
	}

	public BigDecimal getBudgetAmount() {
		return nationDebitMain.getBudgetAmount();
	}

	public void setBudgetAmount(BigDecimal budgetAmount) {
		nationDebitMain.setBudgetAmount(budgetAmount);
	}

	public BigDecimal getRemainRate() {
		return nationDebitMain.getRemainRate();
	}

	public void setRemainRate(BigDecimal remainRate) {
		nationDebitMain.setRemainRate(remainRate);
	}

	public void setNopayAmount(BigDecimal nopayAmount) {
		nationDebitMain.setNopayAmount(nopayAmount);
	}

	public Integer getNationRefId()
	{
		return nationRefId;
	}

	public void setNationRefId(Integer nationRefId)
	{
		this.nationRefId = nationRefId;
	}

	public NationRef getNationCode()
	{
		return nationDebitMain.getNationCode();
	}

	public void setNationCode(NationRef nationCode)
	{
		nationDebitMain.setNationCode(nationCode);
	}

	public String getQryAccountYear()
	{
		return qryAccountYear;
	}

	public void setQryAccountYear(String qryAccountYear)
	{
		if (qryAccountYear.length()<3)
			this.qryAccountYear = "0" + qryAccountYear;
		else if (qryAccountYear.length()<2)
			this.qryAccountYear = "00"+qryAccountYear;
		else
			this.qryAccountYear = qryAccountYear;
	}

	public Integer getQryNationCode()
	{
		return qryNationCode;
	}

	public void setQryNationCode(Integer qryNationCode)
	{
		this.qryNationCode = qryNationCode;
	}

	public NationDebitMain getNationDebitMain()
	{
		return nationDebitMain;
	}

	public void setNationDebitMain(NationDebitMain nationDebitMain)
	{
		this.nationDebitMain = nationDebitMain;
	}

	public String getAccountYear()
	{
		return nationDebitMain.getAccountYear();
	}

	public BigDecimal getBorrowAmount()
	{
		return nationDebitMain.getBorrowAmount();
	}

	public BigDecimal getGdpAmount()
	{
		return nationDebitMain.getGdpAmount();
	}

	public BigDecimal getGnpAmount()
	{
		return nationDebitMain.getGnpAmount();
	}

	public Integer getId()
	{
		return nationDebitMain.getId();
	}

	public BigDecimal getPergnpAmount()
	{
		return nationDebitMain.getPergnpAmount();
	}

	public void setAccountYear(String accountYear)
	{
		nationDebitMain.setAccountYear(accountYear);
	}

	public void setBorrowAmount(BigDecimal borrowAmount)
	{
		nationDebitMain.setBorrowAmount(borrowAmount);
	}

	public void setGdpAmount(BigDecimal gdpAmount)
	{
		nationDebitMain.setGdpAmount(gdpAmount);
	}

	public void setGnpAmount(BigDecimal gnpAmount)
	{
		nationDebitMain.setGnpAmount(gnpAmount);
	}

	public void setId(Integer id)
	{
		nationDebitMain.setId(id);
	}

	public void setPergnpAmount(BigDecimal pergnpAmount)
	{
		nationDebitMain.setPergnpAmount(pergnpAmount);
	}

	public BigDecimal getAuditAmount() {
		return nationDebitMain.getAuditAmount();
	}

	public BigDecimal getGnpYearAmount() {
		return nationDebitMain.getGnpYearAmount();
	}

	public BigDecimal getKeepAmount() {
		return nationDebitMain.getKeepAmount();
	}

	public BigDecimal getRealAmount() {
		return nationDebitMain.getRealAmount();
	}

	public void setAuditAmount(BigDecimal auditAmount) {
		nationDebitMain.setAuditAmount(auditAmount);
	}

	public void setGnpYearAmount(BigDecimal gnpYearAmount) {
		nationDebitMain.setGnpYearAmount(gnpYearAmount);
	}

	public void setKeepAmount(BigDecimal keepAmount) {
		nationDebitMain.setKeepAmount(keepAmount);
	}

	public void setRealAmount(BigDecimal realAmount) {
		nationDebitMain.setRealAmount(realAmount);
	}

	public BigDecimal getGnpAccountAmount() {
		return nationDebitMain.getGnpAccountAmount();
	}

	public void setGnpAccountAmount(BigDecimal gnpAccountAmount) {
		nationDebitMain.setGnpAccountAmount(gnpAccountAmount);
	}

	public BigDecimal getCaseRate() {
		return nationDebitMain.getCaseRate();
	}

	public void setCaseRate(BigDecimal caseRate) {
		nationDebitMain.setCaseRate(caseRate);
	}

	public BigDecimal getRemainPayRate() {
		return nationDebitMain.getRemainPayRate();
	}

	public void setRemainPayRate(BigDecimal remainPayRate) {
		nationDebitMain.setRemainPayRate(remainPayRate);
	}
	public void clean(){
		nationDebitMain = new NationDebitMain ();
		nationRefId = null;
	}

	public BigDecimal getGnpYearAmount1() {
		return nationDebitMain.getGnpYearAmount1();
	}

	public void setGnpYearAmount1(BigDecimal gnpYearAmount1) {
		nationDebitMain.setGnpYearAmount1(gnpYearAmount1);
	}
	
}
