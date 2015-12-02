/**
 * 
 */
package com.system.loan.dto.session;

/**
 * @author VIRAK_PC
 *
 */
public class USER_SESSION {
	private int coId;
	private String coNm;
	private boolean other_edit_prof;
	/**
	 * @return the coId
	 */
	public int getCoId() {
		return coId;
	}
	/**
	 * @param coId the coId to set
	 */
	public void setCoId(int coId) {
		this.coId = coId;
	}
	/**
	 * @return the coNm
	 */
	public String getCoNm() {
		return coNm;
	}
	/**
	 * @return the other_edit_prof
	 */
	public boolean isOther_edit_prof() {
		return other_edit_prof;
	}
	/**
	 * @param other_edit_prof the other_edit_prof to set
	 */
	public void setOther_edit_prof(boolean other_edit_prof) {
		this.other_edit_prof = other_edit_prof;
	}
	/**
	 * @param coNm the coNm to set
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	
	
	

}
