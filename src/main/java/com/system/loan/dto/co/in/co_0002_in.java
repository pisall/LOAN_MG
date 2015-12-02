/**
 * 
 */
package com.system.loan.dto.co.in;

import java.io.Serializable;

/**
 * @author VIRAK_PC
 *
 */
@SuppressWarnings("serial")
public class co_0002_in implements Serializable{
	
	private int co_id;
	private String co_nm;
	private boolean enabled;
	private boolean other_edit_prof;
	
	
	
	/**
	 * @return the co_id
	 */
	public int getCo_id() {
		return co_id;
	}

	/**
	 * @param co_id the co_id to set
	 */
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}


	/**
	 * @return the co_nm
	 */
	public String getCo_nm() {
		return co_nm;
	}


	/**
	 * @param co_nm the co_nm to set
	 */
	public void setCo_nm(String co_nm) {
		this.co_nm = co_nm;
	}
	


	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		System.out.println("set="+other_edit_prof);
		this.other_edit_prof = other_edit_prof;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result=new StringBuffer();
		result.append("co_id:"+this.co_id+",\n");
		result.append("co_nm:"+this.co_nm+"\n");
		result.append("enabled:"+this.enabled+"\n");
		result.append("other_edit_prof:"+this.other_edit_prof);
		
		return result.toString();
	}

}
