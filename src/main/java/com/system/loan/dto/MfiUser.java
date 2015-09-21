package com.system.loan.dto;

public class MfiUser {
	private Integer usID ;
	private String usNM;
	private String usSex;
	private String usPhoto;
	private String usPhone;
	private String usEmail;
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
	 * @return the usNM
	 */
	public String getUsNM() {
		return usNM;
	}
	/**
	 * @param usNM the usNM to set
	 */
	public void setUsNM(String usNM) {
		this.usNM = usNM;
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
		return "MfiUser [usID=" + usID + ", usNM=" + usNM + ", usSex=" + usSex
				+ ", usPhoto=" + usPhoto + ", usPhone=" + usPhone
				+ ", usEmail=" + usEmail + "]";
	}
	
	

}
