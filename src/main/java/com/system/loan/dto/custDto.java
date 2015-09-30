/**
 * 
 */
package com.system.loan.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author PC_VIRAK
 *
 */


@Entity
@Table(name="mfi_customers")
public class custDto implements Serializable {
	@Id
	@Column(name="cu_id")
	private Integer cuId;
	
	//co_id
	/*@ManyToOne( cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
		@JoinTable(name="mfi_co",
				joinColumns=@JoinColumn(name="co_id"),
				inverseJoinColumns=@JoinColumn(name="co_id"))*/
	
	@ManyToOne
    @JoinColumn(name="co_id", insertable=false, updatable=false)
	private CoDto codto;
	
	@Column(name="cu_nm")
	private String cuNm;
	
	@Column(name="cu_nick_nm")
	private Integer cuNickNm;
	
	@Column(name="cu_sex")
	private Integer cuSex;
	
	@Column(name="dob")
	private Integer dob;
	
	@Column(name="cu_national_id")
	private Integer cuNationalId;
	
	@Column(name="cu_phone")
	private Integer cuPhone;
	
	@Column(name="cu_address")
	private Integer cuAddress;
	
	@Column(name="cu_pawn")
	private Integer cuPawn;
	
	@Column(name="cu_dtt")
	private Integer cuDtt;

	/**
	 * @return the cuId
	 */
	public Integer getCuId() {
		return cuId;
	}

	/**
	 * @param cuId the cuId to set
	 */
	public void setCuId(Integer cuId) {
		this.cuId = cuId;
	}

	/**
	 * @return the codto
	 */
	public CoDto getCodto() {
		return codto;
	}

	/**
	 * @param codto the codto to set
	 */
	public void setCodto(CoDto codto) {
		this.codto = codto;
	}

	/**
	 * @return the cuNm
	 */
	public String getCuNm() {
		return cuNm;
	}

	/**
	 * @param cuNm the cuNm to set
	 */
	public void setCuNm(String cuNm) {
		this.cuNm = cuNm;
	}

	/**
	 * @return the cuNickNm
	 */
	public Integer getCuNickNm() {
		return cuNickNm;
	}

	/**
	 * @param cuNickNm the cuNickNm to set
	 */
	public void setCuNickNm(Integer cuNickNm) {
		this.cuNickNm = cuNickNm;
	}

	/**
	 * @return the cuSex
	 */
	public Integer getCuSex() {
		return cuSex;
	}

	/**
	 * @param cuSex the cuSex to set
	 */
	public void setCuSex(Integer cuSex) {
		this.cuSex = cuSex;
	}

	/**
	 * @return the dob
	 */
	public Integer getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Integer dob) {
		this.dob = dob;
	}

	/**
	 * @return the cuNationalId
	 */
	public Integer getCuNationalId() {
		return cuNationalId;
	}

	/**
	 * @param cuNationalId the cuNationalId to set
	 */
	public void setCuNationalId(Integer cuNationalId) {
		this.cuNationalId = cuNationalId;
	}

	/**
	 * @return the cuPhone
	 */
	public Integer getCuPhone() {
		return cuPhone;
	}

	/**
	 * @param cuPhone the cuPhone to set
	 */
	public void setCuPhone(Integer cuPhone) {
		this.cuPhone = cuPhone;
	}

	/**
	 * @return the cuAddress
	 */
	public Integer getCuAddress() {
		return cuAddress;
	}

	/**
	 * @param cuAddress the cuAddress to set
	 */
	public void setCuAddress(Integer cuAddress) {
		this.cuAddress = cuAddress;
	}

	/**
	 * @return the cuPawn
	 */
	public Integer getCuPawn() {
		return cuPawn;
	}

	/**
	 * @param cuPawn the cuPawn to set
	 */
	public void setCuPawn(Integer cuPawn) {
		this.cuPawn = cuPawn;
	}

	/**
	 * @return the cuDtt
	 */
	public Integer getCuDtt() {
		return cuDtt;
	}

	/**
	 * @param cuDtt the cuDtt to set
	 */
	public void setCuDtt(Integer cuDtt) {
		this.cuDtt = cuDtt;
	}
	
	
	
	

}
