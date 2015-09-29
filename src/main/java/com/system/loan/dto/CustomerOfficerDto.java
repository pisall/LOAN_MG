package com.system.loan.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

//@Entity(name = "ForeignKeyAssoEntity")
@Entity
@Table(name = "mfi_co", uniqueConstraints = @UniqueConstraint(columnNames = "co_id") )
public class CustomerOfficerDto implements Serializable {
	/*
	 * customer officer sequence
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "SQ_CO_ID", name = "co_id")
	@GeneratedValue(generator = "", strategy = GenerationType.SEQUENCE)

	/*
	 * customer officer information
	 */

	@Column(name = "co_id")
	private Integer coID;

	@OneToMany( cascade =CascadeType.ALL, fetch=FetchType.EAGER )
    @JoinTable(name="cu_co",
        joinColumns = @JoinColumn(name="co_id"),
        inverseJoinColumns = @JoinColumn(name="cu_id")
    )
	private Set<CustomerDto> customer;
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
	 * 
	 */
	public CustomerOfficerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param coID
	 * @param coName
	 * @param coFirstname
	 * @param coSex
	 * @param coNationalID
	 * @param coBrand
	 * @param coPhone
	 * @param coCpmPhone
	 * @param coDob
	 * @param coAddress
	 */
	public CustomerOfficerDto(Integer coID, String coName, String coFirstname, String coSex, String coNationalID,
			String coBrand, String coPhone, String coCpmPhone, String coDob, String coAddress) {
		super();
		this.coID = coID;
		this.coName = coName;
		this.coFirstname = coFirstname;
		this.coSex = coSex;
		this.coNationalID = coNationalID;
		this.coBrand = coBrand;
		this.coPhone = coPhone;
		this.coCpmPhone = coCpmPhone;
		this.coDob = coDob;
		this.coAddress = coAddress;
	}

	/**
	 * @param coID
	 * @param customer
	 * @param coName
	 * @param coFirstname
	 * @param coSex
	 * @param coNationalID
	 * @param coBrand
	 * @param coPhone
	 * @param coCpmPhone
	 * @param coDob
	 * @param coAddress
	 */
	public CustomerOfficerDto(Integer coID, Set<CustomerDto> customer, String coName, String coFirstname, String coSex,
			String coNationalID, String coBrand, String coPhone, String coCpmPhone, String coDob, String coAddress) {
		super();
		this.coID = coID;
		this.customer = customer;
		this.coName = coName;
		this.coFirstname = coFirstname;
		this.coSex = coSex;
		this.coNationalID = coNationalID;
		this.coBrand = coBrand;
		this.coPhone = coPhone;
		this.coCpmPhone = coCpmPhone;
		this.coDob = coDob;
		this.coAddress = coAddress;
	}

	/**
	 * @return the coID
	 */
	public Integer getCoID() {
		return coID;
	}

	/**
	 * @param coID
	 *            the coID to set
	 */
	public void setCoID(Integer coID) {
		this.coID = coID;
	}

	/**
	 * @return the customer
	 */
	public Set<CustomerDto> getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Set<CustomerDto> customer) {
		this.customer = customer;
	}

	/**
	 * @return the coName
	 */
	public String getCoName() {
		return coName;
	}

	/**
	 * @param coName
	 *            the coName to set
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
	 * @param coFirstname
	 *            the coFirstname to set
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
	 * @param coSex
	 *            the coSex to set
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
	 * @param coNationalID
	 *            the coNationalID to set
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
	 * @param coBrand
	 *            the coBrand to set
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
	 * @param coPhone
	 *            the coPhone to set
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
	 * @param coCpmPhone
	 *            the coCpmPhone to set
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
	 * @param coDob
	 *            the coDob to set
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
	 * @param coAddress
	 *            the coAddress to set
	 */
	public void setCoAddress(String coAddress) {
		this.coAddress = coAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerOfficer [coID=" + coID + ", customer=" + customer + ", coName=" + coName + ", coFirstname="
				+ coFirstname + ", coSex=" + coSex + ", coNationalID=" + coNationalID + ", coBrand=" + coBrand
				+ ", coPhone=" + coPhone + ", coCpmPhone=" + coCpmPhone + ", coDob=" + coDob + ", coAddress="
				+ coAddress + "]";
	}

}
