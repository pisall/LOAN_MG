package com.system.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mfi_customers")
public class LoanAgreementDto {

	/*
	 * User info 
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1,sequenceName="SQ_CU_ID",name="cu_id")
	@GeneratedValue(generator="cu_id", strategy=GenerationType.SEQUENCE)
	
	@Column(name="cu_id")
	private Integer cu_id;
	@Column(name="cu_nm")
	private String cu_nm;
	@Column(name="cu_nick_nm")
	private String cu_nick_nm;
	@Column(name="cu_sex")
	private String cu_sex;
	@Column(name="cu_dob")
	private String cu_dob;
	@Column(name="cu_national_id")
	private String cu_id_card;
	@Column(name="cu_phone")
	private String cu_phone;
	@Column(name="cu_address")
	private String cu_address;
	@Column(name="cu_pawn")
	private String cu_pawn; 
	@Column(name="note")
	private String cu_note;
	@Column(name="photo")
	private String cu_photo;
	
	public LoanAgreementDto(){
		
	}
	
	public LoanAgreementDto(Integer cu_id, String cu_nm, String cu_nick_nm, String cu_sex, String cu_dob,
			String cu_id_card, String cu_phone, String cu_address, String cu_pawn, String cu_note, String cu_photo) {
		super();
		this.cu_id = cu_id;
		this.cu_nm = cu_nm;
		this.cu_nick_nm = cu_nick_nm;
		this.cu_sex = cu_sex;
		this.cu_dob = cu_dob;
		this.cu_id_card = cu_id_card;
		this.cu_phone = cu_phone;
		this.cu_address = cu_address;
		this.cu_pawn = cu_pawn;
		this.cu_note = cu_note;
		this.cu_photo = cu_photo;
	}
	public Integer getCu_id() {
		return cu_id;
	}
	public void setCu_id(Integer cu_id) {
		this.cu_id = cu_id;
	}
	public String getCu_nm() {
		return cu_nm;
	}
	public void setCu_nm(String cu_nm) {
		this.cu_nm = cu_nm;
	}
	public String getCu_nick_nm() {
		return cu_nick_nm;
	}
	public void setCu_nick_nm(String cu_nick_nm) {
		this.cu_nick_nm = cu_nick_nm;
	}
	public String getCu_sex() {
		return cu_sex;
	}
	public void setCu_sex(String cu_sex) {
		this.cu_sex = cu_sex;
	}
	public String getCu_dob() {
		return cu_dob;
	}
	public void setCu_dob(String cu_dob) {
		this.cu_dob = cu_dob;
	}
	public String getCu_id_card() {
		return cu_id_card;
	}
	public void setCu_id_card(String cu_id_card) {
		this.cu_id_card = cu_id_card;
	}
	public String getCu_phone() {
		return cu_phone;
	}
	public void setCu_phone(String cu_phone) {
		this.cu_phone = cu_phone;
	}
	public String getCu_address() {
		return cu_address;
	}
	public void setCu_address(String cu_address) {
		this.cu_address = cu_address;
	}
	public String getCu_pawn() {
		return cu_pawn;
	}
	public void setCu_pawn(String cu_pawn) {
		this.cu_pawn = cu_pawn;
	}
	public String getCu_note() {
		return cu_note;
	}
	public void setCu_note(String cu_note) {
		this.cu_note = cu_note;
	}
	public String getCu_photo() {
		return cu_photo;
	}
	public void setCu_photo(String cu_photo) {
		this.cu_photo = cu_photo;
	}
	 
	 
}
