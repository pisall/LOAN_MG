package com.system.loan.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="mfi_customers")
public class LoanAgreementDto implements Serializable {

	/*
	 * User info 
	 */

	@SequenceGenerator(allocationSize=1, initialValue=1,sequenceName="SQ_CU_ID",name="cu_id")
	@GeneratedValue(generator="cu_id", strategy=GenerationType.SEQUENCE) 
	@Id
	@Column(name="cu_id")
	private Integer cu_id;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="co_id")
	private CoDto coDto;
	 
	//@ElementCollection 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@OneToMany(targetEntity=AcountInfoDto.class, cascade=CascadeType.ALL, mappedBy="loanAGr")
	private Set<AcountInfoDto> acountInfoHash= new HashSet();
	
//	@ElementCollection
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@OneToMany(targetEntity=GuarantorInfoLoanerDto.class, cascade=CascadeType.ALL, mappedBy="loanAgre")
	private Set<GuarantorInfoLoanerDto> gurantorInfoHash = new HashSet();
	
	//@ElementCollection
	@OneToMany(targetEntity=TransectionDto.class, cascade=CascadeType.ALL,mappedBy="loanAgreement")
	private Set<TransectionDto>transection = new HashSet<TransectionDto>();

	
	@Column(name="cu_nm")
	private String cu_nm;
	
	@Column(name="cu_nick_nm")
	private String cu_nick_nm;
	
	@Column(name="cu_sex")
	private String cu_sex;
	
	@Column(name="cu_dob")
	private String cu_dob;
	
	@Column(name="cu_national_id")
	private String cu_national_id;
	
	@Column(name="cu_phone")
	private String cu_phone;
	
	@Column(name="cu_address")
	private String cu_address;
	
	@Column(name="cu_pawn")
	private String cu_pawn; 
	
	@Column(name="cu_dtt")
	private String cu_dtt;

	@Column(name="note")
	private String cu_note;
	
	@Column(name="photo")
	private String cu_photo;
	
	@Column(name="cu_del_yn")
	private String cu_del_yn;
	
	public LoanAgreementDto(){
		
	} 
	public LoanAgreementDto(Integer cu_id, CoDto coDto, String cu_nm, String cu_nick_nm, String cu_sex, String cu_dob,
			String cu_national_id, String cu_phone, String cu_address, String cu_pawn, String cu_dtt, String cu_note,
			String cu_photo,String cu_del_yn) {
		super();
		this.cu_id = cu_id;
		this.coDto = coDto;
		this.cu_nm = cu_nm;
		this.cu_nick_nm = cu_nick_nm;
		this.cu_sex = cu_sex;
		this.cu_dob = cu_dob;
		this.cu_national_id = cu_national_id;
		this.cu_phone = cu_phone;
		this.cu_address = cu_address;
		this.cu_pawn = cu_pawn;
		this.cu_dtt = cu_dtt;
		this.cu_note = cu_note;
		this.cu_photo = cu_photo;
		this.cu_del_yn=cu_del_yn;
	}
	
	
	
 
	public Set<GuarantorInfoLoanerDto> getGurantorInfoHash() {
		return gurantorInfoHash;
	}
	public void setGurantorInfoHash(Set<GuarantorInfoLoanerDto> gurantorInfoHash) {
		this.gurantorInfoHash = gurantorInfoHash;
	}
	public Set<TransectionDto> getTransection() {
		return transection;
	}
	public void setTransection(Set<TransectionDto> transection) {
		this.transection = transection;
	}
	public Integer getCu_id() {
		return cu_id;
	}



	public void setCu_id(Integer cu_id) {
		this.cu_id = cu_id;
	}



	public CoDto getCoDto() {
		return coDto;
	}



	public void setCoDto(CoDto coDto) {
		this.coDto = coDto;
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



	public String getCu_national_id() {
		return cu_national_id;
	}



	public void setCu_national_id(String cu_national_id) {
		this.cu_national_id = cu_national_id;
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



	public String getCu_dtt() {
		return cu_dtt;
	}



	public void setCu_dtt(String cu_dtt) {
		this.cu_dtt = cu_dtt;
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



	public Set<AcountInfoDto> getAcountInfoHash() {
		return acountInfoHash;
	}

	public void setAcountInfoHash(Set<AcountInfoDto> acountInfoHash) {
		this.acountInfoHash = acountInfoHash;
	}
	
	public String getCu_del_yn() {
		return cu_del_yn;
	}
	public void setCu_del_yn(String cu_del_yn) {
		this.cu_del_yn = cu_del_yn;
	}
	
	
	/*
	public Set<GuarantorInfoDto> getGurantorInfoHash() {
		return gurantorInfoHash;
	}

	public void setGurantorInfoHash(Set<GuarantorInfoDto> gurantorInfoHash) {
		this.gurantorInfoHash = gurantorInfoHash;
	}*/
 
}
