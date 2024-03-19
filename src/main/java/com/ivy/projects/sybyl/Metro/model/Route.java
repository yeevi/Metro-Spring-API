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
@Table(name="ROUTE")
@AllArgsConstructor
public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "R_ID")
	private int rId;	//Column data type: INT

	@Column(name = "ROUTE_NAME")
	private String routeName;	//Column data type: VARCHAR


	public Route() {
		super();
	}

	public int getRId() {
		return rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

}

