/**
 * 
 */
package com.system.loan.dto;

/**
 * @author PC_VIRAK
 *
 */
public class pagingDto {
	private int pageNo;
	private int pcnt;
	private int total;
	private int totalPage;
	private String sw;
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the pcnt
	 */
	public int getPcnt() {
		return pcnt;
	}
	/**
	 * @param pcnt the pcnt to set
	 */
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the sw
	 */
	public String getSw() {
		return sw;
	}
	/**
	 * @param sw the sw to set
	 */
	public void setSw(String sw) {
		this.sw = sw;
	}
	
	
	
	

}
