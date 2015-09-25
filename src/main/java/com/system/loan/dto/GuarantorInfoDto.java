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

}
