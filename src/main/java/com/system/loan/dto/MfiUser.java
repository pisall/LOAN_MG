package com.system.loan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mfi_user")
public class MfiUser {
	@Id
	@GeneratedValue
	@Column(name="us_id")
	private Integer usID ;
	@Column(name="us_nm")
	private String usNm;
	@Column(name="us_sex")
	private String usSex;
	@Column(name="us_photo")
	private String usPhoto;
	@Column(name="us_phone")
	private String usPhone;
	@Column(name="us_email")
	private String usEmail;
	@Column(name="us_address")
	private String usAddress;
	/**
	 * @return the usNm
	 */
	public String getUsNm() {
		return usNm;
	}
	/**
	 * @param usNm the usNm to set
	 */
	public void setUsNm(String usNm) {
		this.usNm = usNm;
	}
	/**
	 * @return the usAddress
	 */
	public String getUsAddress() {
		return usAddress;
	}
	/**
	 * @param usAddress the usAddress to set
	 */
	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}
	/**
	 * @return the usID
	 */
	public Integer getUsID() {
		return usID;
	}
	/**
	 * @param usID the usID to set
	 */
	public void setUsID(Integer usID) {
		this.usID = usID;
	}
	/**
	 * @return the usSex
	 */
	public String getUsSex() {
		return usSex;
	}
	/**
	 * @param usSex the usSex to set
	 */
	public void setUsSex(String usSex) {
		this.usSex = usSex;
	}
	/**
	 * @return the usPhoto
	 */
	public String getUsPhoto() {
		return usPhoto;
	}
	/**
	 * @param usPhoto the usPhoto to set
	 */
	public void setUsPhoto(String usPhoto) {
		this.usPhoto = usPhoto;
	}
	/**
	 * @return the usPhone
	 */
	public String getUsPhone() {
		return usPhone;
	}
	/**
	 * @param usPhone the usPhone to set
	 */
	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}
	/**
	 * @return the usEmail
	 */
	public String getUsEmail() {
		return usEmail;
	}
	/**
	 * @param usEmail the usEmail to set
	 */
	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MfiUser [usID=" + usID + ", usNm=" + usNm + ", usSex=" + usSex
				+ ", usPhoto=" + usPhoto + ", usPhone=" + usPhone
				+ ", usEmail=" + usEmail + ", usAddress=" + usAddress + "]";
	}
	
	
}
