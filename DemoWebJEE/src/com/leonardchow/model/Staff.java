package com.leonardchow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_list")
public class Staff {
	
	@Id
	@GeneratedValue
	@Column(name = "staff_id")
	private int staffId;
	private String name;
	@Column(name = "contact_no")
	private int contactNo;
	private String email;
	@Column(name = "home_address")
	private String homeAddress;
	private String designation;
	@Column(name = "a_leave")
	private int aLeave;
	@Column(name = "m_leave")
	private int mLeave;
	@Column(name = "c_leave")
	private int cLeave;
	@Column(name = "reports_to")
	private int reportsTo;
	@Column(name = "total_hours_claimed")
	private int totalHoursClaimed;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getaLeave() {
		return aLeave;
	}
	public void setaLeave(int aLeave) {
		this.aLeave = aLeave;
	}
	public int getmLeave() {
		return mLeave;
	}
	public void setmLeave(int mLeave) {
		this.mLeave = mLeave;
	}
	public int getcLeave() {
		return cLeave;
	}
	public void setcLeave(int cLeave) {
		this.cLeave = cLeave;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public int getTotalHoursClaimed() {
		return totalHoursClaimed;
	}
	public void setTotalHoursClaimed(int totalHoursClaimed) {
		this.totalHoursClaimed = totalHoursClaimed;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", name=" + name + ", contactNo=" + contactNo + ", email=" + email
				+ ", homeAddress=" + homeAddress + ", designation=" + designation + ", aLeave=" + aLeave + ", mLeave="
				+ mLeave + ", cLeave=" + cLeave + ", reportsTo=" + reportsTo + ", totalHoursClaimed="
				+ totalHoursClaimed + "]";
	}

}
