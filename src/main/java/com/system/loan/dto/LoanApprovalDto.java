package com.system.loan.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="mfi_loanApproval")
public class LoanApprovalDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="loan_approve",name="loa_id")
	@GeneratedValue(generator="loa_id",strategy=GenerationType.SEQUENCE)
	
	@Column(name="loa_id")
	private int loa_id;
	
	@Column(name="co_id")
	private int co_id;
	
	@Column(name="cu_id")
	private int cu_id;
	 
	
	@Column(name="ac_id")
	private int ac_id;
	
	@Column(name="tr_id")
	private int tr_id;
	
	@Column(name="paid_amount")
	private float paid_amount;
	
	@Column(name="amount_fine")
	private float amount_fine ;
	
	@Column(name="days_late")
	private float days_late ;
	
	@Column(name="pre_pay")
	private float pre_pay ;

	@Column(name="total_paid_amount")
	private float total_paid_amount ;
	
	@Column(name="balance")
	private float balance ;
	
	@Column(name="tr_type")
	private String tr_type;
	
	@Column(name="approve_note")
	private String approve_note;
	
	@Column(name="tr_dtt")
	private String tr_dtt;
	
	public LoanApprovalDto(){
		
	}
	
	public LoanApprovalDto(int loa_id, int co_id, int cu_id , int ac_id, int tr_id, float paid_amount,
			float amount_fine, String tr_type, String approve_note, String tr_dtt) {
		super();
		this.loa_id = loa_id;
		this.co_id = co_id;
		this.cu_id = cu_id; 
		this.ac_id = ac_id;
		this.tr_id = tr_id;
		this.paid_amount = paid_amount;
		this.amount_fine = amount_fine;
		this.tr_type = tr_type;
		this.approve_note = approve_note;
		this.tr_dtt=tr_dtt;
	}

	
	public int getLoa_id() {
		return loa_id;
	}

	public void setLoa_id(int loa_id) {
		this.loa_id = loa_id;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public int getCu_id() {
		return cu_id;
	}

	public void setCu_id(int cu_id) {
		this.cu_id = cu_id;
	}
 
	public int getAc_id() {
		return ac_id;
	}

	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}

	public int getTr_id() {
		return tr_id;
	}

	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}

	public float getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}

	/**
	 * @return the total_paid_amount
	 */
	public float getTotal_paid_amount() {
		return total_paid_amount;
	}

	/**
	 * @param total_paid_amount the total_paid_amount to set
	 */
	public void setTotal_paid_amount(float total_paid_amount) {
		this.total_paid_amount = total_paid_amount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getDays_late() {
		return days_late;
	}

	public void setDays_late(float days_late) {
		this.days_late = days_late;
	}

	public float getPre_pay() {
		return pre_pay;
	}

	public void setPre_pay(float pre_pay) {
		this.pre_pay = pre_pay;
	}

	public float getAmount_fine() {
		return amount_fine;
	}

	public void setAmount_fine(float amount_fine) {
		this.amount_fine = amount_fine;
	}

	public String getTr_type() {
		return tr_type;
	}

	public void setTr_type(String tr_type) {
		this.tr_type = tr_type;
	}

	public String getApprove_note() {
		return approve_note;
	}

	public void setApprove_note(String approve_note) {
		this.approve_note = approve_note;
	}

	public String getTr_dtt() {
		return tr_dtt;
	}

	public void setTr_dtt(String tr_dtt) {
		this.tr_dtt = tr_dtt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoanApprovalDto [loa_id=" + loa_id + ", co_id=" + co_id + ", cu_id=" + cu_id + ", ac_id=" + ac_id
				+ ", tr_id=" + tr_id + ", paid_amount=" + paid_amount + ", amount_fine=" + amount_fine + ", days_late="
				+ days_late + ", pre_pay=" + pre_pay + ", total_paid_amount=" + total_paid_amount + ", tr_type="
				+ tr_type + ", approve_note=" + approve_note + ", tr_dtt=" + tr_dtt + "]";
	}
	 
}
