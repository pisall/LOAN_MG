package com.system.loan.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="mfi_customers")
public class CustomerDto implements Serializable {
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_CU_ID",name="cu_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)	 
	@Column(name="cu_id")
	private Integer cuID;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customerDto")
	private Set<GuarantorInfoDto>guarantorInfoDto;
	
	@Column(name="co_id")
	private Integer coID;
	@Column(name="cu_nm")
	private String cuName;
	@Column(name="cu_nick_nm")
	private String cuNickName;
	@Column(name="cu_sex")
	private String cuSex;
	@Column(name="cu_dob")
	private String cuDOB;
	@Column(name="cu_national_id")
	private Integer cuNationalID;
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
	@Column(name="cu_del_yn")
	private String cuDelYn;
	

	
	/**
	 * @return the guarantorInfoDto
	 */
	public Set<GuarantorInfoDto> getGuarantorInfoDto() {
		return guarantorInfoDto;
	}
	/**
	 * @param guarantorInfoDto the guarantorInfoDto to set
	 */
	public void setGuarantorInfoDto(Set<GuarantorInfoDto> guarantorInfoDto) {
		this.guarantorInfoDto = guarantorInfoDto;
	}
	/**
	 * @return the cuID
	 */
	public Integer getCuID() {
		return cuID;
	}
	/**
	 * @param cuID the cuID to set
	 */
	public void setCuID(Integer cuID) {
		this.cuID = cuID;
	}
	
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
	 * @return the cuName
	 */
	public String getCuName() {
		return cuName;
	}
	/**
	 * @param cuName the cuName to set
	 */
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	/**
	 * @return the cuNickName
	 */
	public String getCuNickName() {
		return cuNickName;
	}
	/**
	 * @param cuNickName the cuNickName to set
	 */
	public void setCuNickName(String cuNickName) {
		this.cuNickName = cuNickName;
	}
	/**
	 * @return the cuSex
	 */
	public String getCuSex() {
		return cuSex;
	}
	/**
	 * @param cuSex the cuSex to set
	 */
	public void setCuSex(String cuSex) {
		this.cuSex = cuSex;
	}
	/**
	 * @return the cuDOB
	 */
	public String getCuDOB() {
		return cuDOB;
	}
	/**
	 * @param cuDOB the cuDOB to set
	 */
	public void setCuDOB(String cuDOB) {
		this.cuDOB = cuDOB;
	}
	/**
	 * @return the cuNationalID
	 */
	public Integer getCuNationalID() {
		return cuNationalID;
	}
	/**
	 * @param cuNationalID the cuNationalID to set
	 */
	public void setCuNationalID(Integer cuNationalID) {
		this.cuNationalID = cuNationalID;
	}
	/**
	 * @return the cuPhone
	 */
	public String getCuPhone() {
		return cuPhone;
	}
	/**
	 * @param cuPhone the cuPhone to set
	 */
	public void setCuPhone(String cuPhone) {
		this.cuPhone = cuPhone;
	}
	/**
	 * @return the cuAddress
	 */
	public String getCuAddress() {
		return cuAddress;
	}
	/**
	 * @param cuAddress the cuAddress to set
	 */
	public void setCuAddress(String cuAddress) {
		this.cuAddress = cuAddress;
	}
	/**
	 * @return the cuPawn
	 */
	public String getCuPawn() {
		return cuPawn;
	}
	/**
	 * @param cuPawn the cuPawn to set
	 */
	public void setCuPawn(String cuPawn) {
		this.cuPawn = cuPawn;
	}
	/**
	 * @return the cuDtt
	 */
	public String getCuDtt() {
		return cuDtt;
	}
	/**
	 * @param cuDtt the cuDtt to set
	 */
	public void setCuDtt(String cuDtt) {
		this.cuDtt = cuDtt;
	}
	/**
	 * @return the cuNote
	 */
	public String getCuNote() {
		return cuNote;
	}
	/**
	 * @param cuNote the cuNote to set
	 */
	public void setCuNote(String cuNote) {
		this.cuNote = cuNote;
	}
	/**
	 * @return the cuPhoto
	 */
	public String getCuPhoto() {
		return cuPhoto;
	}
	/**
	 * @param cuPhoto the cuPhoto to set
	 */
	public void setCuPhoto(String cuPhoto) {
		this.cuPhoto = cuPhoto;
	}
	
	/**
	 * @return the cuDelYn
	 */
	public String getCuDelYn() {
		return cuDelYn;
	}
	/**
	 * @param cuDelYn the cuDelYn to set
	 */
	public void setCuDelYn(String cuDelYn) {
		this.cuDelYn = cuDelYn;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerDto [cuID=" + cuID + ", cuName=" + cuName + ", cuNickName=" + cuNickName + ", cuSex=" + cuSex
				+ ", cuDOB=" + cuDOB + ", cuNationalID=" + cuNationalID + ", cuPhone=" + cuPhone + ", cuAddress="
				+ cuAddress + ", cuPawn=" + cuPawn + ", cuDtt=" + cuDtt + ", cuNote=" + cuNote + ", cuPhoto=" + cuPhoto
				+ ", cuDelYn=" + cuDelYn + "]";
	}
	
}
