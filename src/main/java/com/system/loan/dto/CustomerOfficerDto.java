package com.system.loan.dto;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="mfi_co")
public class CustomerOfficerDto {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "SQ_CO_ID", name = "co_id")
	@GeneratedValue(generator = "", strategy = GenerationType.SEQUENCE)

	/*
	 * customer officer information
	 */

	@Column(name = "co_id")
	private Integer coID;

	@OneToMany( cascade =CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy="co" )
	private List<CustomerDto> customer=new ArrayList<CustomerDto>();
	@Column(name = "co_nm")
	private String coName;
	@Column(name = "co_first_nm")
	private String coFirstname;
	@Column(name = "co_sex")
	private String coSex;
	@Column(name = "co_national_id")
	private String coNationalID;
	@Column(name = "co_brand")
	private String coBrand;
	@Column(name = "co_phone")
	private String coPhone;
	@Column(name = "co_cpm_phone")
	private String coCpmPhone;
	@Column(name = "dob")
	private String coDob;
	@Column(name = "address")
	private String coAddress;
	/**
	 * @return the coID
	 */
	public Integer getCoID() {
		return coID;
	}
	/**
	 * @param coID the coID to set
	 */
	public void setCoID(Integer coID) {
		this.coID = coID;
	}
	/**
	 * @return the customer
	 */
	public List<CustomerDto> getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(List<CustomerDto> customer) {
		this.customer = customer;
	}
	/**
	 * @return the coName
	 */
	public String getCoName() {
		return coName;
	}
	/**
	 * @param coName the coName to set
	 */
	public void setCoName(String coName) {
		this.coName = coName;
	}
	/**
	 * @return the coFirstname
	 */
	public String getCoFirstname() {
		return coFirstname;
	}
	/**
	 * @param coFirstname the coFirstname to set
	 */
	public void setCoFirstname(String coFirstname) {
		this.coFirstname = coFirstname;
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
	 * @return the coNationalID
	 */
	public String getCoNationalID() {
		return coNationalID;
	}
	/**
	 * @param coNationalID the coNationalID to set
	 */
	public void setCoNationalID(String coNationalID) {
		this.coNationalID = coNationalID;
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
	 * @return the coDob
	 */
	public String getCoDob() {
		return coDob;
	}
	/**
	 * @param coDob the coDob to set
	 */
	public void setCoDob(String coDob) {
		this.coDob = coDob;
	}
	/**
	 * @return the coAddress
	 */
	public String getCoAddress() {
		return coAddress;
	}
	/**
	 * @param coAddress the coAddress to set
	 */
	public void setCoAddress(String coAddress) {
		this.coAddress = coAddress;
	}
	
	
}
