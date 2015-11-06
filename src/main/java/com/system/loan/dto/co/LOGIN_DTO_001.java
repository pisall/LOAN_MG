/**
 * 
 */
package com.system.loan.dto.co;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.system.loan.dao.co.CO_DAO_001_IMP;

/**
 * @author VIRAK_PC
 *
 */
@Entity
@Table(name="mfi_login")
public class LOGIN_DTO_001 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sq_log_id")
	@SequenceGenerator(name="sq_log_id", sequenceName="sq_log_id", allocationSize=1)
	@Column(name="log_in")
	private int log_in;
	
	@Column(name="log_email")
	private String log_email;
	
	@Column(name="log_password")
	private String log_password;
	
	@Column(name="log_type")
	private String log_type;
	
	/*@Column(name="co_id", unique=true, nullable=false)
    @GeneratedValue(generator="generator")
	@GenericGenerator(name = "generator", strategy = "foreign",	parameters =@Parameter(name="property",value="co")) 
	private int co_id;*/
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="co_id")
	private CO_DTO_001 coDTO;
	
	/**
	 * @return the log_in
	 */
	public int getLog_in() {
		return log_in;
	}

	/**
	 * @param log_in the log_in to set
	 */
	public void setLog_in(int log_in) {
		this.log_in = log_in;
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
	 * @return the log_password
	 */
	public String getLog_password() {
		return log_password;
	}

	/**
	 * @param log_password the log_password to set
	 */
	public void setLog_password(String log_password) {
		this.log_password = log_password;
	}

	/**
	 * @return the log_type
	 */
	public String getLog_type() {
		return log_type;
	}

	/**
	 * @param log_type the log_type to set
	 */
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	/**
	 * @return the coDTO
	 */
	public CO_DTO_001 getCoDTO() {
		return coDTO;
	}

	/**
	 * @param coDTO the coDTO to set
	 */
	public void setCoDTO(CO_DTO_001 coDTO) {
		this.coDTO = coDTO;
	}

	
	/**
	 * @return the co_id
	 */
	/*public int getCo_id() {
		return co_id;
	}

	*//**
	 * @param co_id the co_id to set
	 *//*
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
*/
	/**
	 * @return the co
	 */
	/*@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "co_id")
	public CO_DTO_001 getCo() {
		return co;
	}

	*//**
	 * @param co the co to set
	 *//*
	
	public void setCo(CO_DTO_001 co) {
		this.co = co;
	}
	*/
	
	
	
}
