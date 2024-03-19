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
@Table(name="ROUTE_DATA")
@AllArgsConstructor
public class RouteData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RD_ID")
	private int rdId;	//Column data type: INT

	@Column(name = "R_ID")
	private String rId;	//Column data type: VARCHAR

	@Column(name = "DESTINATION_ID")
	private String destinationId;	//Column data type: VARCHAR


	public RouteData() {
		super();
	}

	public int getRdId() {
		return rdId;
	}

	public void setRdId(int rdId) {
		this.rdId = rdId;
	}

	public String getRId() {
		return rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

}

