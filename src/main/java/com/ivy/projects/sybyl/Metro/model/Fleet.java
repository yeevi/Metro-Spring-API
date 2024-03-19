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
@Table(name="FLEET")
@AllArgsConstructor
public class Fleet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FLEET_NO")
	private int fleetNo;	//Column data type: INT

	@Column(name = "NO_OF_PASSENGERS")
	private int noOf;	//Column data type: INT

	@Column(name = "R_ID")
	private String rId;	//Column data type: VARCHAR

	@Column(name = "STATUS")
	private String status;	//Column data type: VARCHAR


	public Fleet() {
		super();
	}

	public int getFleetNo() {
		return fleetNo;
	}

	public void setFleetNo(int fleetNo) {
		this.fleetNo = fleetNo;
	}

	public int getNoOf() {
		return noOf;
	}

	public void setNoOf(int noOf) {
		this.noOf = noOf;
	}

	public String getRId() {
		return rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

