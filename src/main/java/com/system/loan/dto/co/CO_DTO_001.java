/**
 * 
 */
package com.system.loan.dto.co;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VIRAK_PC
 *
 */
@Entity
@Table(name="mfi_co")
public class CO_DTO_001 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sq_co_id")
	@SequenceGenerator(name="sq_co_id", sequenceName="sq_co_id", allocationSize=1)
	@Column(name="co_id")
	private int co_id;
	
	@Column(name="co_first_nm",nullable=true)
	private String co_first_nm;
	
	@Column(name="co_last_nm",nullable=true)
	private String co_last_nm;
	
	@Column(name="co_sex",nullable=true)
	private String co_sex;
	
	@Column(name="co_national_id")
	private String co_national_id;
	
	@Column(name="co_brand",nullable=true)
	private String co_brand;
	
	@Column(name="co_phone")
	private String co_phone;
	
	@Column(name="co_cpm_phone",nullable=true)
	private String co_cpm_phone;
	
	@Column(name="dob",nullable=true)
	private String dob;
	
	@Column(name="address",nullable=true)
	private String address;
	
	@Column(name="co_pb_address",nullable=true)
	private String co_pb_address;
	
	@Column(name="reg_dtt")
	private String reg_dtt;
	
	@Column(name="update_dtt")
	private String update_dtt;
	
	/*@Column(name="reg_co_id")
	private int reg_co_id;*/
	
	
	@ManyToOne
	@JoinColumn(name="reg_co_id")
	private CO_DTO_001 regCo;
	
	@OneToMany(mappedBy="regCo")
	private Set<CO_DTO_001> subordinats=new HashSet<CO_DTO_001>();
	
	
//	private LOGIN_DTO_001 login;
	
	@OneToOne(mappedBy="coDTO")
	private LOGIN_DTO_001 loginDTO;
	
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
	 * @return the reg_dtt
	 */
	public String getReg_dtt() {
		return reg_dtt;
	}

	/**
	 * @param reg_dtt the reg_dtt to set
	 */
	public void setReg_dtt(String reg_dtt) {
		this.reg_dtt = reg_dtt;
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
	
	

	/**
	 * @return the reg_co_id
	 */
	/*public int getReg_co_id() {
		return reg_co_id;
	}*/

	/**
	 * @param reg_co_id the reg_co_id to set
	 */
	/*public void setReg_co_id(int reg_co_id) {
		this.reg_co_id = reg_co_id;
	}*/

	/**
	 * @return the loginDTO
	 */
	public LOGIN_DTO_001 getLoginDTO() {
		return loginDTO;
	}

	/**
	 * @param loginDTO the loginDTO to set
	 */
	public void setLoginDTO(LOGIN_DTO_001 loginDTO) {
		this.loginDTO = loginDTO;
	}

	/**
	 * @return the regCo
	 */
	public CO_DTO_001 getRegCo() {
		return regCo;
	}

	/**
	 * @param regCo the regCo to set
	 */
	public void setRegCo(CO_DTO_001 regCo) {
		this.regCo = regCo;
	}

	/**
	 * @return the subordinats
	 */
	public Set<CO_DTO_001> getSubordinats() {
		return subordinats;
	}

	/**
	 * @param subordinats the subordinats to set
	 */
	public void setSubordinats(Set<CO_DTO_001> subordinats) {
		this.subordinats = subordinats;
	}
	
	

	
	/**
	 * @return the login
	 */
/*	@OneToOne(fetch=FetchType.EAGER,mappedBy="co",cascade=CascadeType.ALL)
	public LOGIN_DTO_001 getLogin() {
		return login;
	}

	*//**
	 * @param login the login to set
	 *//*
	public void setLogin(LOGIN_DTO_001 login) {
		this.login = login;
	}*/
	
	
	

}
