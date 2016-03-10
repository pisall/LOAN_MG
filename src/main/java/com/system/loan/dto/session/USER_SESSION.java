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
	private String logType;
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
	 * @param coNm the coNm to set
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
}
