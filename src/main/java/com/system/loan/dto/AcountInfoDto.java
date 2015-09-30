package com.system.loan.dto;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.management.Query;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Entity
@Table(name="mfi_account")
public class AcountInfoDto implements Serializable {
	 @Resource(name="sessionFactory")
	 private SessionFactory sessionFactory;
	/*
	 * account sequence
	 */
	@Autowired
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_AC_ID",name="ac_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	 
	/*
	 * acountinfo
	 */
	
	@Column(name="ac_id")
	private Integer AcId;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="us_id")
	private LoanAgreementDto loanAgreementDto;
	
	@Column(name="us_id")
	private Integer us_id;
	
	@Column(name="co_id")
	private Integer co_id;
	
	@Column(name="ac_amount")
	private float ac_amount;
	
	@Column(name="ac_rate")
	private float ac_rate;
	
	@Column(name="ac_type")
	private String ac_type;
	
	@Column(name="ac_period")
	private String ac_period;
	
	@Column(name="ac_period_type")
	private String ac_period_type;
	
	@Column(name="ac_stat")
	private String ac_stat;
	
	@Column(name="ac_start_date")
	private String ac_start_date;
	
	@Column(name="ac_end_date")
	private String ac_end_date;
	
	public AcountInfoDto(){
		
	}

	public Integer getAcId() {
		return AcId;
	}

	public void setAcId(Integer acId) {
		AcId = acId;
	}

	public Integer getUs_id() {
		return us_id;
	}

	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}

	public Integer getCo_id() {
		return co_id;
	}

	public void setCo_id(Integer co_id) {
		this.co_id = co_id;
	}

	public float getAc_amount() {
		return ac_amount;
	}

	public void setAc_amount(float ac_amount) {
		this.ac_amount = ac_amount;
	}

	public float getAc_rate() {
		return ac_rate;
	}

	public void setAc_rate(float ac_rate) {
		this.ac_rate = ac_rate;
	}

	public String getAc_type() {
		return ac_type;
	}

	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}

	public String getAc_period() {
		return ac_period;
	}

	public void setAc_period(String ac_period) {
		this.ac_period = ac_period;
	}

	public String getAc_period_type() {
		return ac_period_type;
	}

	public void setAc_period_type(String ac_period_type) {
		this.ac_period_type = ac_period_type;
	}

	public String getAc_stat() {
		return ac_stat;
	}

	public void setAc_stat(String ac_stat) {
		this.ac_stat = ac_stat;
	}

	public String getAc_start_date() {
		return ac_start_date;
	}

	public void setAc_start_date(String ac_start_date) {
		this.ac_start_date = ac_start_date;
	}

	public String getAc_end_date() {
		return ac_end_date;
	}

	public void setAc_end_date(String ac_end_date) {
		this.ac_end_date = ac_end_date;
	}
	 
	 
}
