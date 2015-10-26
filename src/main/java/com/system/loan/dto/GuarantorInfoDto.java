package com.system.loan.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="mfi_guarantor")
public class GuarantorInfoDto implements Serializable { 
	/*
	 * Guarantor info "this info not full need to modify later"
	 * 
	 */  
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_GU_ID",name="gu_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	
	@Column(name="gu_id")
	private Integer gu_id;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cu_id")
	private LoanAgreementDto loanAgreementDto;*/
	
	@ManyToOne
	@JoinColumn(name="cu_id")
	private CustomerDto customerDto;
	
	/*@Column (name="cu_id")
	private Integer cuID; */
	
	@Column(name="gu_nm")
	private String gu_nm;
	
	@Column(name="gu_nick_nm")
	private String gu_nick_nm;
	
	@Column(name="gu_sex")
	private String gu_sex;
	
	@Column(name="gu_national_id")
	private String gu_national_id;
	
	@Column(name="gu_dob")
	private String gu_dob;
	
	@Column(name="gu_phone")
	private String gu_phone;
	
	@Column(name="gu_address")
	private String gu_address;
	
	@Column(name="gu_pawn")
	private String gu_pawn;
	
	@Column(name="gu_note")
	private String gu_note;
	
	@Column(name="gu_dtt")
	private String gu_dtt;
	
	@Column(name="photo")
	private String photo;
	

	/**
	 * @return the customerDto
	 */
	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	/**
	 * @param customerDto the customerDto to set
	 */
	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public GuarantorInfoDto(){
		
	}

	public Integer getGu_id() {
		return gu_id;
	}

	public void setGu_id(Integer gu_id) {
		this.gu_id = gu_id;
	}

/*	public Integer getCu_id() {
		return cuID;
	}

	public void setCu_id(Integer cu_id) {
		this.cuID = cu_id;
	}*/

	public String getGu_nm() {
		return gu_nm;
	}

	public void setGu_nm(String gu_nm) {
		this.gu_nm = gu_nm;
	}

	/**
	 * @return the gu_nick_nm
	 */
	public String getGu_nick_nm() {
		return gu_nick_nm;
	}

	/**
	 * @param gu_nick_nm the gu_nick_nm to set
	 */
	public void setGu_nick_nm(String gu_nick_nm) {
		this.gu_nick_nm = gu_nick_nm;
	}

	/**
	 * @return the gu_pawn
	 */
	public String getGu_pawn() {
		return gu_pawn;
	}

	/**
	 * @param gu_pawn the gu_pawn to set
	 */
	public void setGu_pawn(String gu_pawn) {
		this.gu_pawn = gu_pawn;
	}

	public String getGu_sex() {
		return gu_sex;
	}

	public void setGu_sex(String gu_sex) {
		this.gu_sex = gu_sex;
	}

	public String getGu_national_id() {
		return gu_national_id;
	}

	public void setGu_national_id(String gu_national_id) {
		this.gu_national_id = gu_national_id;
	}

	/**
	 * @return the gu_dob
	 */
	public String getGu_dob() {
		return gu_dob;
	}

	/**
	 * @param gu_dob the gu_dob to set
	 */
	public void setGu_dob(String gu_dob) {
		this.gu_dob = gu_dob;
	}

	public String getGu_phone() {
		return gu_phone;
	}

	public void setGu_phone(String gu_phone) {
		this.gu_phone = gu_phone;
	}

	public String getGu_address() {
		return gu_address;
	}

	public void setGu_address(String gu_address) {
		this.gu_address = gu_address;
	}

	public String getGu_note() {
		return gu_note;
	}

	public void setGu_note(String gu_note) {
		this.gu_note = gu_note;
	}

	public String getGu_dtt() {
		return gu_dtt;
	}

	public void setGu_dtt(String gu_dtt) {
		this.gu_dtt = gu_dtt;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
	 
}
