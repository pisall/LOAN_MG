package com.system.loan.holiday;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="holiday")
public class HolidayDto {
	
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="hol_id",name="hol_id")
	@GeneratedValue(generator="",strategy=GenerationType.SEQUENCE)	 
	@Column(name="hol_id")
	private int holID;
	@Column(name="hol_name")
	private String holName;
	@Column(name="hol_date")
	private String holDate;
	@Column(name="hol_day")
	private String holDay;
	@Column(name="hol_description")
	private String holDescription;
	
	
	/**
	 * 
	 */
	public HolidayDto() {
		super();
	}


	/**
	 * @param holID
	 * @param holName
	 * @param holDate
	 * @param holDay
	 * @param holDescription
	 */
	public HolidayDto(int holID, String holName, String holDate, String holDay, String holDescription) {
		super();
		this.holID = holID;
		this.holName = holName;
		this.holDate = holDate;
		this.holDay = holDay;
		this.holDescription = holDescription;
	}


	/**
	 * @return the holID
	 */
	public int getHolID() {
		return holID;
	}


	/**
	 * @param holID the holID to set
	 */
	public void setHolID(int holID) {
		this.holID = holID;
	}


	/**
	 * @return the holName
	 */
	public String getHolName() {
		return holName;
	}


	/**
	 * @param holName the holName to set
	 */
	public void setHolName(String holName) {
		this.holName = holName;
	}


	/**
	 * @return the holDate
	 */
	public String getHolDate() {
		return holDate;
	}


	/**
	 * @param holDate the holDate to set
	 */
	public void setHolDate(String holDate) {
		this.holDate = holDate;
	}


	/**
	 * @return the holDay
	 */
	public String getHolDay() {
		return holDay;
	}


	/**
	 * @param holDay the holDay to set
	 */
	public void setHolDay(String holDay) {
		this.holDay = holDay;
	}


	/**
	 * @return the holDescription
	 */
	public String getHolDescription() {
		return holDescription;
	}


	/**
	 * @param holDescription the holDescription to set
	 */
	public void setHolDescription(String holDescription) {
		this.holDescription = holDescription;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HolidayDto [holID=" + holID + ", holName=" + holName + ", holDate=" + holDate + ", holDay=" + holDay
				+ ", holDescription=" + holDescription + "]";
	}
	
}
