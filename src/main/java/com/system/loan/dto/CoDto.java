package com.system.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mfi_co")
public class CoDto {
	@Id
	@GeneratedValue
	@Column(name="co_id")
	private int coId;
	
	@Column(name="co_first_nm")
	private String coFirstNm;
	
	@Column(name="co_last_nm")
	private String coLastNm;
	
	@Column(name="co_sex")
	private String coSex;
	
	@Column(name="co_national_id")
	private String coNationalId;
	
	@Column(name="co_brand")
	private String coBrand;
	
	@Column(name="co_phone")
	private String coPhone;
	
	@Column(name="co_cpm_phone")
	private String coCpmPhone;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="address")
	private String address;

	/**
	 * @return the coId
	 */
	public int getCoId() {
		return coId;
	}

	/**
	 * @param coId the coId to set
	 */
	public void setCoId(int coId) {
		this.coId = coId;
	}

	/**
	 * @return the coFirstNm
	 */
	public String getCoFirstNm() {
		return coFirstNm;
	}

	/**
	 * @param coFirstNm the coFirstNm to set
	 */
	public void setCoFirstNm(String coFirstNm) {
		this.coFirstNm = coFirstNm;
	}

	/**
	 * @return the coLastNm
	 */
	public String getCoLastNm() {
		return coLastNm;
	}

	/**
	 * @param coLastNm the coLastNm to set
	 */
	public void setCoLastNm(String coLastNm) {
		this.coLastNm = coLastNm;
	}

	/**
	 * @return the coSex
	 */
	public String getCoSex() {
		return coSex;
	}

	/**
	 * @param coSex the coSex to set
	 */
	public void setCoSex(String coSex) {
		this.coSex = coSex;
	}

	/**
	 * @return the coNationalId
	 */
	public String getCoNationalId() {
		return coNationalId;
	}

	/**
	 * @param coNationalId the coNationalId to set
	 */
	public void setCoNationalId(String coNationalId) {
		this.coNationalId = coNationalId;
	}

	/**
	 * @return the coBrand
	 */
	public String getCoBrand() {
		return coBrand;
	}

	/**
	 * @param coBrand the coBrand to set
	 */
	public void setCoBrand(String coBrand) {
		this.coBrand = coBrand;
	}

	/**
	 * @return the coPhone
	 */
	public String getCoPhone() {
		return coPhone;
	}

	/**
	 * @param coPhone the coPhone to set
	 */
	public void setCoPhone(String coPhone) {
		this.coPhone = coPhone;
	}

	/**
	 * @return the coCpmPhone
	 */
	public String getCoCpmPhone() {
		return coCpmPhone;
	}

	/**
	 * @param coCpmPhone the coCpmPhone to set
	 */
	public void setCoCpmPhone(String coCpmPhone) {
		this.coCpmPhone = coCpmPhone;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
