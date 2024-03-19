package com.ivy.projects.sybyl.Metro.model;


import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name="RESERVATION")
@AllArgsConstructor
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RES_ID")
	private int resId;	//Column data type: INT

	@Column(name = "P_ID")
	private String pId;	//Column data type: VARCHAR

	@Column(name = "R_ID")
	private String rId;	//Column data type: VARCHAR

	@Column(name = "D_ID")
	private String dId;	//Column data type: VARCHAR

	@Column(name = "TRAVEL_DATE")
	private String travelDate;	//Column data type: VARCHAR

	@Column(name = "FLEET_NO")
	private String fleetNo;	//Column data type: VARCHAR


	public Reservation() {
		super();
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public String getRId() {
		return rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getDId() {
		return dId;
	}

	public void setDId(String dId) {
		this.dId = dId;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getFleetNo() {
		return fleetNo;
	}

	public void setFleetNo(String fleetNo) {
		this.fleetNo = fleetNo;
	}

}

