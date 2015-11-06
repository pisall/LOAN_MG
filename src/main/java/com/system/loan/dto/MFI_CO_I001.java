/**
 * 
 */
package com.system.loan.dto;

import java.io.Serializable;

/**
 * @author PC_VIRAK
 *
 */
public class MFI_CO_I001 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5424935218461628170L;
	private int CO_ID;
	private String CO_FIRST_NM;
	private String CO_LAST_NM;
	private pagingDto paging;
	
	
	public MFI_CO_I001(){
		paging=new pagingDto();
	}
	
	public MFI_CO_I001(int cO_ID, String cO_FIRST_NM, String cO_LAST_NM, pagingDto paging) {
		super();
		CO_ID = cO_ID;
		CO_FIRST_NM = cO_FIRST_NM;
		CO_LAST_NM = cO_LAST_NM;
		this.paging = paging;
	}
	/**
	 * @return the cO_ID
	 */
	public int getCO_ID() {
		return CO_ID;
	}
	/**
	 * @param cO_ID the cO_ID to set
	 */
	public void setCO_ID(int cO_ID) {
		CO_ID = cO_ID;
	}
	/**
	 * @return the cO_FIRST_NM
	 */
	public String getCO_FIRST_NM() {
		return CO_FIRST_NM;
	}
	/**
	 * @param cO_FIRST_NM the cO_FIRST_NM to set
	 */
	public void setCO_FIRST_NM(String cO_FIRST_NM) {
		CO_FIRST_NM = cO_FIRST_NM;
	}
	/**
	 * @return the cO_LAST_NM
	 */
	public String getCO_LAST_NM() {
		return CO_LAST_NM;
	}
	/**
	 * @param cO_LAST_NM the cO_LAST_NM to set
	 */
	public void setCO_LAST_NM(String cO_LAST_NM) {
		CO_LAST_NM = cO_LAST_NM;
	}
	
	
	
	/**
	 * @return the paging
	 */
	public pagingDto getPaging() {
		return paging;
	}
	/**
	 * @param paging the paging to set
	 */
	public void setPaging(pagingDto paging) {
		this.paging = paging;
	}
	@Override
	public String toString(){
		StringBuffer buff=new StringBuffer();
		//open tage
		buff.append("{");
		
		buff.append("paging:"+paging.toString()+",");
		//System.out.println(paging.toString());
		buff.append("CO_ID:"+ CO_ID+",");
		buff.append("CO_FIRST_NM:"+ CO_FIRST_NM+",");
		//last element
		buff.append("CO_LAST_NM:"+ CO_LAST_NM);
		
		//close tag
		buff.append("}");
		return buff.toString();
		
	}

	
}
