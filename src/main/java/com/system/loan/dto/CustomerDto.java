package com.system.loan.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//@Entity(name = "ForeignKeyAssocuDto")
/*@Table(name = "mfi_customers", uniqueConstraints =@UniqueConstraint(columnNames = "cu_id"))*/

@Entity
@Table(name="mfi_customers")
public class CustomerDto implements Serializable {
	/*
	 * cu sequence
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_CU_ID",name="cu_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	 
	@Column(name="cu_id")
	private Integer cuID;
	@ManyToOne()
	@JoinColumn(name="co_id")
	private CustomerOfficerDto co;
	@Column(name="cu_nm")
	private String cuName;
	@Column(name="cu_nick_nm")
	private String cuNickName;
	@Column(name="cu_sex")
	private String cuSex;
	@Column(name="cu_dob")
	private String cuDOB;
	@Column(name="cu_national_id")
	private String cuNationalID;
	@Column(name="cu_phone")
	private String cuPhone;
	@Column(name="cu_address")
	private String cuAddress;
	@Column(name="cu_pawn")
	private String cuPawn;
	@Column(name="cu_dtt")
	private String cuDtt;
	@Column(name="cu_note")
	private String cuNote;
	@Column(name="cu_photo")
	private String cuPhoto;
	
	
	/**
	 * 
	 */
	public CustomerDto() {
		super();
		
	}
	
	
	/**
	 * @param cuID
	 * @param cuOfficer
	 * @param cuName
	 * @param custoemrNickName
	 * @param cuSex
	 * @param cuDOB
	 * @param cuNationalID
	 * @param cuPhone
	 * @param cuAddress
	 * @param cuPawn
	 * @param cuDtt
	 * @param cuNote
	 * @param cuPhoto
	 */
	public CustomerDto(Integer cuID, CustomerOfficerDto co, String cuName,
			String custoemrNickName, String cuSex, String cuDOB, String cuNationalID,
			String cuPhone, String cuAddress, String cuPawn, String cuDtt, String cuNote,
			String cuPhoto) {
		super();
		this.cuID = cuID;
		this.co=co;
		this.cuName = cuName;
		this.cuNickName = custoemrNickName;
		this.cuSex = cuSex;
		this.cuDOB = cuDOB;
		this.cuNationalID = cuNationalID;
		this.cuPhone = cuPhone;
		this.cuAddress = cuAddress;
		this.cuPawn = cuPawn;
		this.cuDtt = cuDtt;
		this.cuNote = cuNote;
		this.cuPhoto = cuPhoto;
	}


	/**
	 * @param cuID
	 * @param cuName
	 * @param custoemrNickName
	 * @param cuSex
	 * @param cuDOB
	 * @param cuNationalID
	 * @param cuPhone
	 * @param cuAddress
	 * @param cuPawn
	 * @param cuDtt
	 */
	public CustomerDto(Integer cuID, String cuName, String custoemrNickName, String cuSex,
			String cuDOB, String cuNationalID, String cuPhone, String cuAddress,
			String cuPawn, String cuDtt) {
		super();
		this.cuID = cuID;
		this.cuName = cuName;
		this.cuNickName = custoemrNickName;
		this.cuSex = cuSex;
		this.cuDOB = cuDOB;
		this.cuNationalID = cuNationalID;
		this.cuPhone = cuPhone;
		this.cuAddress = cuAddress;
		this.cuPawn = cuPawn;
		this.cuDtt = cuDtt;
	}
	
	
	/**
	 * @return the cuID
	 */
	public Integer getcuID() {
		return cuID;
	}
	/**
	 * @param cuID the cuID to set
	 */
	public void setcuID(Integer cuID) {
		this.cuID = cuID;
	}
	
	/**
	 * @return the cuOfficer
	 */
	public CustomerOfficerDto cuOfficer() {
		return cuOfficer();
	}
	
	/**
	 * @return the cuName
	 */
	public String getcuName() {
		return cuName;
	}
	/**
	 * @param cuName the cuName to set
	 */
	public void setcuName(String cuName) {
		this.cuName = cuName;
	}
	/**
	 * @return the custoemrNickName
	 */
	public String getCustoemrNickName() {
		return cuNickName;
	}
	/**
	 * @param custoemrNickName the custoemrNickName to set
	 */
	public void setCustoemrNickName(String custoemrNickName) {
		this.cuNickName = custoemrNickName;
	}
	/**
	 * @return the cuSex
	 */
	public String getcuSex() {
		return cuSex;
	}
	/**
	 * @param cuSex the cuSex to set
	 */
	public void setcuSex(String cuSex) {
		this.cuSex = cuSex;
	}
	/**
	 * @return the cuDOB
	 */
	public String getcuDOB() {
		return cuDOB;
	}
	/**
	 * @param cuDOB the cuDOB to set
	 */
	public void setcuDOB(String cuDOB) {
		this.cuDOB = cuDOB;
	}
	/**
	 * @return the cuNationalID
	 */
	public String getcuNationalID() {
		return cuNationalID;
	}
	/**
	 * @param cuNationalID the cuNationalID to set
	 */
	public void setcuNationalID(String cuNationalID) {
		this.cuNationalID = cuNationalID;
	}
	/**
	 * @return the cuPhone
	 */
	public String getcuPhone() {
		return cuPhone;
	}
	/**
	 * @param cuPhone the cuPhone to set
	 */
	public void setcuPhone(String cuPhone) {
		this.cuPhone = cuPhone;
	}
	/**
	 * @return the cuAddress
	 */
	public String getcuAddress() {
		return cuAddress;
	}
	/**
	 * @param cuAddress the cuAddress to set
	 */
	public void setcuAddress(String cuAddress) {
		this.cuAddress = cuAddress;
	}
	/**
	 * @return the cuPawn
	 */
	public String getcuPawn() {
		return cuPawn;
	}
	/**
	 * @param cuPawn the cuPawn to set
	 */
	public void setcuPawn(String cuPawn) {
		this.cuPawn = cuPawn;
	}
	/**
	 * @return the cuDtt
	 */
	public String getcuDtt() {
		return cuDtt;
	}
	/**
	 * @param cuDtt the cuDtt to set
	 */
	public void setcuDtt(String cuDtt) {
		this.cuDtt = cuDtt;
	}
	/**
	 * @return the cuNote
	 */
	public String getcuNote() {
		return cuNote;
	}
	/**
	 * @param cuNote the cuNote to set
	 */
	public void setcuNote(String cuNote) {
		this.cuNote = cuNote;
	}
	/**
	 * @return the cuPhoto
	 */
	public String getcuPhoto() {
		return cuPhoto;
	}
	/**
	 * @param cuPhoto the cuPhoto to set
	 */
	public void setcuPhoto(String cuPhoto) {
		this.cuPhoto = cuPhoto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "cuDto [cuID=" + cuID + ", co=" + co + ", cuName="
				+ cuName + ", custoemrNickName=" + cuNickName + ", cuSex=" + cuSex
				+ ", cuDOB=" + cuDOB + ", cuNationalID=" + cuNationalID + ", cuPhone="
				+ cuPhone + ", cuAddress=" + cuAddress + ", cuPawn=" + cuPawn
				+ ", cuDtt=" + cuDtt + ", cuNote=" + cuNote + ", cuPhoto=" + cuPhoto
				+ "]";
	}
	
	
	
}
