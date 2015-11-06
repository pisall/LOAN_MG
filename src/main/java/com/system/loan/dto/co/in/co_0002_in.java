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
	
	public co_0002_in(){
		
	}
	
	private int co_id;
	private String co_nm;
	
	
	
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result=new StringBuffer();
		result.append("co_id:"+this.co_id+",\n");
		result.append("co_nm:"+this.co_nm+"\n");
		
		return result.toString();
	}

}
