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
	private int CO_ID;
	private String CO_FIRST_NM;
	private String CO_LAST_NM;
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
	
	@Override
	public String toString(){
		return "!not yes impliment";
		
	}

	
}
