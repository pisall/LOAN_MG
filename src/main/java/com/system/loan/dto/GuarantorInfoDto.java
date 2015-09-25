package com.system.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mfi_guarantor")
public class GuarantorInfoDto { 
	/*
	 * Guarantor info "this info not full need to modify later"
	 * 
	 */  
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="SQ_GU_ID",name="gu_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)
	
	@Column(name="gu_id")
	private Integer GuId;
	@Column (name="cu_id")
	private Integer CuId; 
	@Column(name="gu_nm")
	private String gu_full_nm;
	@Column(name="gu_sex")
	private String GuSex;
	@Column(name="gu_national_id")
	private String gu_id_card;
	@Column(name="gu_phone")
	private String gu_Phone;
	@Column(name="gu_address")
	private String guaddress;
	@Column(name="gu_note")
	private String gu_note;
	@Column(name="gu_dtt")
	private String dtt;
	@Column(name="photo")
	private String Photo;
	
	public GuarantorInfoDto(){
		
	}
	
	
	public GuarantorInfoDto(Integer guId, Integer cuId, String gu_full_nm, String guSex, String gu_id_card,
			String gu_Phone, String guaddress, String gu_note, String dtt, String photo) {
		super();
		GuId = guId;
		CuId = cuId;
		this.gu_full_nm = gu_full_nm;
		GuSex = guSex;
		this.gu_id_card = gu_id_card;
		this.gu_Phone = gu_Phone;
		this.guaddress = guaddress;
		this.gu_note = gu_note;
		this.dtt = dtt;
		Photo = photo;
	}
	public Integer getGuId() {
		return GuId;
	}
	public void setGuId(Integer guId) {
		GuId = guId;
	}
	public Integer getCuId() {
		return CuId;
	}
	public void setCuId(Integer cuId) {
		CuId = cuId;
	}
	public String getGu_full_nm() {
		return gu_full_nm;
	}
	public void setGu_full_nm(String gu_full_nm) {
		this.gu_full_nm = gu_full_nm;
	}
	public String getGuSex() {
		return GuSex;
	}
	public void setGuSex(String guSex) {
		GuSex = guSex;
	}
	public String getGu_id_card() {
		return gu_id_card;
	}
	public void setGu_id_card(String gu_id_card) {
		this.gu_id_card = gu_id_card;
	}
	public String getGu_Phone() {
		return gu_Phone;
	}
	public void setGu_Phone(String gu_Phone) {
		this.gu_Phone = gu_Phone;
	}
	public String getGuaddress() {
		return guaddress;
	}
	public void setGuaddress(String guaddress) {
		this.guaddress = guaddress;
	}
	public String getGu_note() {
		return gu_note;
	}
	public void setGu_note(String gu_note) {
		this.gu_note = gu_note;
	}
	public String getDtt() {
		return dtt;
	}
	public void setDtt(String dtt) {
		this.dtt = dtt;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
 
}
