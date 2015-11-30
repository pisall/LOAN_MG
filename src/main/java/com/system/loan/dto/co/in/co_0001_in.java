package com.system.loan.dto.co.in;

import java.io.Serializable;

public class co_0001_in implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8043769834783119119L;
	private int co_id;
	private String co_first_nm;
	private String co_last_nm;
	private String co_sex;
	private String co_national_id;
	private String co_brand;
	private String co_phone;
	private String co_cpm_phone;
	private String dob;
	private String co_pb_address;
	private String address;
	private String update_dtt;
	
	private String log_password;
	private String log_email;
	private String confirm_password;
	
	
	
	
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
	 * @return the co_first_nm
	 */
	public String getCo_first_nm() {
		return co_first_nm;
	}
	/**
	 * @param co_first_nm the co_first_nm to set
	 */
	public void setCo_first_nm(String co_first_nm) {
		this.co_first_nm = co_first_nm;
	}
	/**
	 * @return the co_last_nm
	 */
	public String getCo_last_nm() {
		return co_last_nm;
	}
	/**
	 * @param co_last_nm the co_last_nm to set
	 */
	public void setCo_last_nm(String co_last_nm) {
		this.co_last_nm = co_last_nm;
	}
	/**
	 * @return the co_sex
	 */
	public String getCo_sex() {
		return co_sex;
	}
	/**
	 * @param co_sex the co_sex to set
	 */
	public void setCo_sex(String co_sex) {
		this.co_sex = co_sex;
	}
	/**
	 * @return the co_national_id
	 */
	public String getCo_national_id() {
		return co_national_id;
	}
	/**
	 * @param co_national_id the co_national_id to set
	 */
	public void setCo_national_id(String co_national_id) {
		this.co_national_id = co_national_id;
	}
	/**
	 * @return the co_brand
	 */
	public String getCo_brand() {
		return co_brand;
	}
	/**
	 * @param co_brand the co_brand to set
	 */
	public void setCo_brand(String co_brand) {
		this.co_brand = co_brand;
	}
	/**
	 * @return the co_phone
	 */
	public String getCo_phone() {
		return co_phone;
	}
	/**
	 * @param co_phone the co_phone to set
	 */
	public void setCo_phone(String co_phone) {
		this.co_phone = co_phone;
	}
	/**
	 * @return the co_cpm_phone
	 */
	public String getCo_cpm_phone() {
		return co_cpm_phone;
	}
	/**
	 * @param co_cpm_phone the co_cpm_phone to set
	 */
	public void setCo_cpm_phone(String co_cpm_phone) {
		this.co_cpm_phone = co_cpm_phone;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * @return the co_pb_address
	 */
	public String getCo_pb_address() {
		return co_pb_address;
	}
	/**
	 * @param co_pb_address the co_pb_address to set
	 */
	public void setCo_pb_address(String co_pb_address) {
		this.co_pb_address = co_pb_address;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the log_password
	 */
	public String getLog_password() {
		return log_password;
	}
	
	
	/**
	 * @return the confirm_password
	 */
	public String getConfirm_password() {
		return confirm_password;
	}
	/**
	 * @param confirm_password the confirm_password to set
	 */
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	/**
	 * @param log_password the log_password to set
	 */
	public void setLog_password(String log_password) {
		this.log_password = log_password;
	}
	/**
	 * @return the log_email
	 */
	public String getLog_email() {
		return log_email;
	}
	/**
	 * @param log_email the log_email to set
	 */
	public void setLog_email(String log_email) {
		this.log_email = log_email;
	}
	
	
	/**
	 * @return the update_dtt
	 */
	public String getUpdate_dtt() {
		return update_dtt;
	}
	/**
	 * @param update_dtt the update_dtt to set
	 */
	public void setUpdate_dtt(String update_dtt) {
		this.update_dtt = update_dtt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuffer buf=new StringBuffer();
		buf.append("co_first_nm:"+this.co_first_nm+",");
		buf.append("co_last_nm:"+this.co_last_nm+",");
		buf.append("co_sex:"+co_sex+",");
		buf.append("co_national_id:"+this.co_national_id+",");
		buf.append("co_brand:"+this.co_brand+",");
		buf.append("co_phone:"+this.co_phone+",");
		buf.append("co_cpm_phone:"+this.co_cpm_phone+",");
		buf.append("dob:"+this.dob+",");
		buf.append("address:"+this.address+",");
		buf.append("log_password:"+this.log_password+",");
		buf.append("log_password:"+this.log_password+",");
		buf.append("log_email:"+this.log_email);
		return buf.toString();
	}
	
	

}
