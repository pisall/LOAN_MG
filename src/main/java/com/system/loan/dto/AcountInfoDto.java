package com.system.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mfi_account	postgres")
public class AcountInfoDto {
	/*
	 * account sequence
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_AC_ID",name="ac_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	
/*	
	 * User id Sequence
	 
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_US_ID",name="us_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	
	
	 * Co_id sequence
	 
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_CO_ID",name="co_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)*/
	
	/*
	 * acountinfo
	 */
	@Column(name="ac_id")
	private Integer AcId;
	private Integer UserId;
	private Integer CoId;
	@Column(name="ac_amount")
	private float amount;
	@Column(name="cu_id")
	private float rate;
	@Column(name="cu_id")
	private String type;
	@Column(name="cu_id")
	private String period;
	@Column(name="cu_id")
	private String paytype;
	@Column(name="cu_id")
	private String start_date;
	@Column(name="cu_id")
	private String end_date;
	
	public AcountInfoDto(){
		
	}
	
	public AcountInfoDto(Integer acId, Integer userId, Integer coId, float amount, float rate, String type,
			String period, String paytype, String start_date, String end_date) {
		super();
		AcId = acId;
		UserId = userId;
		CoId = coId; 
		this.amount = amount;
		this.rate = rate;
		this.type = type;
		this.period = period;
		this.paytype = paytype;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public Integer getAcId() {
		return AcId;
	}
	public void setAcId(Integer acId) {
		AcId = acId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getCoId() {
		return CoId;
	}
	public void setCoId(Integer coId) {
		CoId = coId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	} 
}
