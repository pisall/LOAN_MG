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
	
	public int getCo_id() {
		return co_id;
	}


	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	private int co_id;
	private String co_nm;
	private String log_email;
	private String log_password;
	private String log_type;
	private boolean enabled;
	
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
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer result=new StringBuffer();
		result.append("co_id:"+this.co_id+",\n");
		result.append("co_nm:"+this.co_nm+"\n");
		result.append("enabled:"+this.enabled+"\n");
		
		return result.toString();
	}

	public String getLog_password() {
		return log_password;
	}

	public void setLog_password(String log_password) {
		this.log_password = log_password;
	}

	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	public String getLog_email() {
		return log_email;
	}

	public void setLog_email(String log_email) {
		this.log_email = log_email;
	}

}
