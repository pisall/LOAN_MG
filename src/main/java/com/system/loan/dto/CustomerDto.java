package com.system.loan.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "mfi_customer", uniqueConstraints =@UniqueConstraint(columnNames = "co_id"))
public class CustomerDto implements Serializable {
	/*
	 * customer sequence
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_CU_ID",name="customer_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	 
	@Column(name="cu_id")
	private Integer customerID;
	@ManyToOne
	private CustomerOfficer customerOfficer;
	@Column(name="cu_nm")
	private String customerName;
	@Column(name="cu_nick_nm")
	private String custoemrNickName;
	@Column(name="cu_sex")
	private String customerSex;
	@Column(name="cu_dob")
	private String customerDOB;
	@Column(name="cu_national_id")
	private String customerNationalID;
	@Column(name="cu_phone")
	private String customerPhone;
	@Column(name="cu_address")
	private String customerAddress;
	@Column(name="cu_pawn")
	private String customerPawn;
	@Column(name="cu_dtt")
	private String customerDtt;
	@Column(name="cu_note")
	private String customerNote;
	@Column(name="cu_photo")
	private String customerPhoto;
	
	
	/**
	 * 
	 */
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param customerID
	 * @param customerOfficer
	 * @param customerName
	 * @param custoemrNickName
	 * @param customerSex
	 * @param customerDOB
	 * @param customerNationalID
	 * @param customerPhone
	 * @param customerAddress
	 * @param customerPawn
	 * @param customerDtt
	 * @param customerNote
	 * @param customerPhoto
	 */
	public CustomerDto(Integer customerID, CustomerOfficer customerOfficer, String customerName,
			String custoemrNickName, String customerSex, String customerDOB, String customerNationalID,
			String customerPhone, String customerAddress, String customerPawn, String customerDtt, String customerNote,
			String customerPhoto) {
		super();
		this.customerID = customerID;
		this.customerOfficer = customerOfficer;
		this.customerName = customerName;
		this.custoemrNickName = custoemrNickName;
		this.customerSex = customerSex;
		this.customerDOB = customerDOB;
		this.customerNationalID = customerNationalID;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerPawn = customerPawn;
		this.customerDtt = customerDtt;
		this.customerNote = customerNote;
		this.customerPhoto = customerPhoto;
	}


	/**
	 * @param customerID
	 * @param customerName
	 * @param custoemrNickName
	 * @param customerSex
	 * @param customerDOB
	 * @param customerNationalID
	 * @param customerPhone
	 * @param customerAddress
	 * @param customerPawn
	 * @param customerDtt
	 */
	public CustomerDto(Integer customerID, String customerName, String custoemrNickName, String customerSex,
			String customerDOB, String customerNationalID, String customerPhone, String customerAddress,
			String customerPawn, String customerDtt) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.custoemrNickName = custoemrNickName;
		this.customerSex = customerSex;
		this.customerDOB = customerDOB;
		this.customerNationalID = customerNationalID;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerPawn = customerPawn;
		this.customerDtt = customerDtt;
	}
	
	
	/**
	 * @return the customerID
	 */
	public Integer getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	
	/**
	 * @return the customerOfficer
	 */
	public CustomerOfficer customerOfficer() {
		return customerOfficer;
	}
	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the custoemrNickName
	 */
	public String getCustoemrNickName() {
		return custoemrNickName;
	}
	/**
	 * @param custoemrNickName the custoemrNickName to set
	 */
	public void setCustoemrNickName(String custoemrNickName) {
		this.custoemrNickName = custoemrNickName;
	}
	/**
	 * @return the customerSex
	 */
	public String getCustomerSex() {
		return customerSex;
	}
	/**
	 * @param customerSex the customerSex to set
	 */
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	/**
	 * @return the customerDOB
	 */
	public String getCustomerDOB() {
		return customerDOB;
	}
	/**
	 * @param customerDOB the customerDOB to set
	 */
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	/**
	 * @return the customerNationalID
	 */
	public String getCustomerNationalID() {
		return customerNationalID;
	}
	/**
	 * @param customerNationalID the customerNationalID to set
	 */
	public void setCustomerNationalID(String customerNationalID) {
		this.customerNationalID = customerNationalID;
	}
	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}
	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the customerPawn
	 */
	public String getCustomerPawn() {
		return customerPawn;
	}
	/**
	 * @param customerPawn the customerPawn to set
	 */
	public void setCustomerPawn(String customerPawn) {
		this.customerPawn = customerPawn;
	}
	/**
	 * @return the customerDtt
	 */
	public String getCustomerDtt() {
		return customerDtt;
	}
	/**
	 * @param customerDtt the customerDtt to set
	 */
	public void setCustomerDtt(String customerDtt) {
		this.customerDtt = customerDtt;
	}
	/**
	 * @return the customerNote
	 */
	public String getCustomerNote() {
		return customerNote;
	}
	/**
	 * @param customerNote the customerNote to set
	 */
	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}
	/**
	 * @return the customerPhoto
	 */
	public String getCustomerPhoto() {
		return customerPhoto;
	}
	/**
	 * @param customerPhoto the customerPhoto to set
	 */
	public void setCustomerPhoto(String customerPhoto) {
		this.customerPhoto = customerPhoto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerDto [customerID=" + customerID + ", customerOfficer=" + customerOfficer + ", customerName="
				+ customerName + ", custoemrNickName=" + custoemrNickName + ", customerSex=" + customerSex
				+ ", customerDOB=" + customerDOB + ", customerNationalID=" + customerNationalID + ", customerPhone="
				+ customerPhone + ", customerAddress=" + customerAddress + ", customerPawn=" + customerPawn
				+ ", customerDtt=" + customerDtt + ", customerNote=" + customerNote + ", customerPhoto=" + customerPhoto
				+ "]";
	}
	
	
	
}
