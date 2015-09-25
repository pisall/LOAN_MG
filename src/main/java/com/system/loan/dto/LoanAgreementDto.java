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
	private String us_nm;
	@Column(name="cu_nick_nm")
	private String us_nick_nm;
	@Column(name="cu_sex")
	private String us_sex;
	@Column(name="cu_dob")
	private String us_dob;
	@Column(name="cu_national_id")
	private String us_id_card;
	@Column(name="cu_phone")
	private String us_phone;
	@Column(name="cu_address")
	private String us_address;
	@Column(name="cu_pawn")
	private String us_pawn;
	@Column(name="note")
	private String note;
	 
	public LoanAgreementDto(){
		  
	}
	 
	public LoanAgreementDto(String us_nm, String us_nick_nm, String us_sex, String us_dob, String us_id_card,
			String us_phone, String us_address, String us_pawn, String end_date , String note) {
		super();
		this.us_nm = us_nm;
		this.us_nick_nm = us_nick_nm;
		this.us_sex = us_sex;
		this.us_dob = us_dob;
		this.us_id_card = us_id_card;
		this.us_phone = us_phone;
		this.us_address = us_address;
		this.us_pawn = us_pawn; 
		this.note=note;
	}
	
	public String getUs_nm() {
		return us_nm;
	}
	public void setUs_nm(String us_nm) {
		this.us_nm = us_nm;
	}
	public String getUs_nick_nm() {
		return us_nick_nm;
	}
	public void setUs_nick_nm(String us_nick_nm) {
		this.us_nick_nm = us_nick_nm;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String us_sex) {
		this.us_sex = us_sex;
	}
	public String getUs_dob() {
		return us_dob;
	}
	public void setUs_dob(String us_dob) {
		this.us_dob = us_dob;
	}
	public String getUs_id_card() {
		return us_id_card;
	}
	public void setUs_id_card(String us_id_card) {
		this.us_id_card = us_id_card;
	}
	public String getUs_phone() {
		return us_phone;
	}
	public void setUs_phone(String us_phone) {
		this.us_phone = us_phone;
	}
	public String getUs_address() {
		return us_address;
	}
	public void setUs_address(String us_address) {
		this.us_address = us_address;
	}
	public String getUs_pawn() {
		return us_pawn;
	}
	public void setUs_pawn(String us_pawn) {
		this.us_pawn = us_pawn;
	}
	  
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	 
}
