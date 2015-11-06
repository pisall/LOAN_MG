package com.system.loan.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
 
@Entity
@Table(name="mfi_account")
public class AcountInfoDto implements Serializable { 
	/*
	 * account sequence
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_AC_ID",name="ac_id")
	@GeneratedValue(generator="ac_id",strategy=GenerationType.SEQUENCE)
	
	@Column(name="ac_id")
	private Integer ac_id;
	
	
	@ManyToOne(targetEntity=LoanAgreementDto.class, cascade= CascadeType.ALL)
	@JoinColumn(name="cu_id")
	private LoanAgreementDto loanAGr;
	
	//@ElementCollection
	@OneToMany(targetEntity=TransectionDto.class, cascade=CascadeType.ALL,mappedBy="account")
	private Set<TransectionDto>transection = new HashSet<TransectionDto>();
	
	
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
	
	@Column(name="ac_saving_amount")
	private float ac_saving_amount;
	
	
	
	
	public AcountInfoDto(){
		 
	} 
	
	
	public AcountInfoDto(Integer ac_id, LoanAgreementDto loanAGr, float ac_amount, float ac_rate, String ac_type,
			String ac_period, String ac_period_type, String ac_stat, String ac_start_date, String ac_end_date,
			float ac_saving_amount) {
		super();
		this.ac_id = ac_id;
		this.loanAGr = loanAGr;
		this.ac_amount = ac_amount;
		this.ac_rate = ac_rate;
		this.ac_type = ac_type;
		this.ac_period = ac_period;
		this.ac_period_type = ac_period_type;
		this.ac_stat = ac_stat;
		this.ac_start_date = ac_start_date;
		this.ac_end_date = ac_end_date;
		this.ac_saving_amount = ac_saving_amount;
	}

	public Integer getAc_id() {
		return ac_id;
	}


	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}
	
	public Set<TransectionDto> getTransection() {
		return transection;
	}

	public void setTransection(Set<TransectionDto> transection) {
		this.transection = transection;
	}

	public float getAc_saving_amount() {
		return ac_saving_amount;
	}

	public void setAc_saving_amount(float ac_saving_amount) {
		this.ac_saving_amount = ac_saving_amount;
	}

	public LoanAgreementDto getLoanAGr() {
		return loanAGr;
	}

	public void setLoanAGr(LoanAgreementDto loanAGr) {
		this.loanAGr = loanAGr;
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
