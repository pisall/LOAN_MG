/**
 * 
 */
package com.system.loan.dto;

import java.io.Serializable;

/**
 * @author PC_VIRAK
 *
 */
public class pagingDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3551241633076213434L;
	
	private int pageNo;
	private int pcnt;
	private int total;
	private int totalPage;
	private String sw;
	private String tr_type;
	
	/**
	 * @return the tr_type
	 */
	public String getTr_type() {
		return tr_type;
	}
	/**
	 * @param tr_type the tr_type to set
	 */
	public void setTr_type(String tr_type) {
		this.tr_type = tr_type;
	}
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
	
	@Override
	public String toString(){
		StringBuffer buff=new StringBuffer();
		//open tage
		buff.append("{");
		
		buff.append("pageNo:"+ pageNo+",");
		buff.append("pcnt:"+ pcnt+",");
		buff.append("total:"+ total+",");
		buff.append("totalPage:"+ totalPage+",");
		
		//total
		//last element
		buff.append("sw:"+ sw);
		
		//close tag
		buff.append("}");
		return buff.toString();
	}
	
	

}
