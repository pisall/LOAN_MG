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
	
	/*
	 * Guarator info "this info not full need to modiy later"
	 * 
	 */
	
	private String gu_full_nm;
	private String gu_id_card;
	private String gu_note;
	
	/*
	 * money info
	 */
	private float amount;
	private float rate;
	private String type;
	private String period;
	private String paytype;
	private String start_date;
	private String end_date;
	
	public void LoanAgreement(){
		  
	}
	 
	public LoanAgreementDto(String us_nm, String us_nick_nm, String us_sex, String us_dob, String us_id_card,
			String us_phone, String us_address, String us_pawn, String gu_full_nm, String gu_id_card, String gu_note,
			float amount, float rate, String type, String period, String paytype, String start_date, String end_date , String note) {
		super();
		this.us_nm = us_nm;
		this.us_nick_nm = us_nick_nm;
		this.us_sex = us_sex;
		this.us_dob = us_dob;
		this.us_id_card = us_id_card;
		this.us_phone = us_phone;
		this.us_address = us_address;
		this.us_pawn = us_pawn;
		this.gu_full_nm = gu_full_nm;
		this.gu_id_card = gu_id_card;
		this.gu_note = gu_note;
		this.amount = amount;
		this.rate = rate;
		this.type = type;
		this.period = period;
		this.paytype = paytype;
		this.start_date = start_date;
		this.end_date = end_date;
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
	public String getGu_full_nm() {
		return gu_full_nm;
	}
	public void setGu_full_nm(String gu_full_nm) {
		this.gu_full_nm = gu_full_nm;
	}
	public String getGu_id_card() {
		return gu_id_card;
	}
	public void setGu_id_card(String gu_id_card) {
		this.gu_id_card = gu_id_card;
	}
	public String getGu_note() {
		return gu_note;
	}
	public void setGu_note(String gu_note) {
		this.gu_note = gu_note;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.end_date = note;
	}
	 
}
