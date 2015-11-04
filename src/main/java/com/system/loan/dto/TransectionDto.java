package com.system.loan.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mfi_transection")
public class TransectionDto implements Serializable{ 
	
		  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		  @Id
		  @SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="sq_tr_id",name="tr_id")
		  @GeneratedValue(generator="tr_id",strategy=GenerationType.SEQUENCE)
		  
		  @Column(name="tr_id")
		  private int tr_id ;  
		 // join table mfi_transection to table mfi_account(Many to One)    
		  //@ElementCollection
		  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
		  @JoinColumn(name="tr_ac_id")  
		  private AcountInfoDto account; 
		  
		  
		  // join table mfin_transection to table mfi_customer (Many to One)
		  //@ElementCollection
		  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
		  @JoinColumn(name="tr_cu_id") 
		  private LoanAgreementDto loanAgreement;
		  
		 
		  @Column(name="tr_origin_amount")
		  private float tr_origin_amount ;
		  
		  @Column(name="tr_save_payment")
		  private float tr_save_payment ;
		  
		  @Column(name="tr_pay_amount")
		  private float tr_pay_amount;
		  
		  @Column(name="tr_balance")
		  private float tr_balance;
		  
		  @Column(name="tr_stts")
		  private String tr_stts;
	 
		  
		  @Column(name="tr_total_rate")
		  private float tr_total_rate ;
		  
		  @Column(name="tr_dtt")
		  private String tr_dtt;
		  
		  @Column(name="pay_date")
		  private String pay_date;
		  
		  @Column(name="pay_day")
		  private String pay_day;
		  
		  public TransectionDto(){
			  
		  }
	  
	  
	
	public TransectionDto(int tr_id, float tr_origin_amount, float tr_save_payment, float tr_pay_amount,
				float tr_balance, String tr_stts, float tr_total_rate, String tr_dtt,
				String pay_date, String pay_day) {
			super();
			this.tr_id = tr_id;
			this.tr_origin_amount = tr_origin_amount;
			this.tr_save_payment = tr_save_payment;
			this.tr_pay_amount = tr_pay_amount;
			this.tr_balance = tr_balance;
			this.tr_stts = tr_stts;
			 
			this.tr_total_rate = tr_total_rate;
			this.tr_dtt = tr_dtt;
			this.pay_date = pay_date;
			this.pay_day = pay_day;
		}



	
	public AcountInfoDto getAccount() {
		return account;
	}



	public void setAccount(AcountInfoDto account) {
		this.account = account;
	}


	

	public LoanAgreementDto getLoanAgreement() {
		return loanAgreement;
	}



	public void setLoanAgreement(LoanAgreementDto loanAgreement) {
		this.loanAgreement = loanAgreement;
	}



	public int getTr_id() {
		return tr_id;
	}



	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}



	public float getTr_origin_amount() {
		return tr_origin_amount;
	}



	public void setTr_origin_amount(float tr_origin_amount) {
		this.tr_origin_amount = tr_origin_amount;
	}
 
	public float getTr_save_payment() {
		return tr_save_payment;
	}



	public void setTr_save_payment(float tr_save_payment) {
		this.tr_save_payment = tr_save_payment;
	}



	public float getTr_pay_amount() {
		return tr_pay_amount;
	}



	public void setTr_pay_amount(float tr_pay_amount) {
		this.tr_pay_amount = tr_pay_amount;
	}



	public float getTr_balance() {
		return tr_balance;
	}



	public void setTr_balance(float tr_balance) {
		this.tr_balance = tr_balance;
	}



	public String getTr_stts() {
		return tr_stts;
	}



	public void setTr_stts(String tr_stts) {
		this.tr_stts = tr_stts;
	}

   
	public float getTr_total_rate() {
		return tr_total_rate;
	}



	public void setTr_total_rate(float tr_total_rate) {
		this.tr_total_rate = tr_total_rate;
	}



	public String getTr_dtt() {
		return tr_dtt;
	}



	public void setTr_dtt(String tr_dtt) {
		this.tr_dtt = tr_dtt;
	}



	public String getPay_date() {
		return pay_date;
	}



	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}



	public String getPay_day() {
		return pay_day;
	}



	public void setPay_day(String pay_day) {
		this.pay_day = pay_day;
	}

 
}
