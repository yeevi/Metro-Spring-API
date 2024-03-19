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
@Table(name="PASSENGER")
@AllArgsConstructor
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "P_ID")
	private int pId;	//Column data type: INT

	@Column(name = "name")
	private String name;	//Column data type: VARCHAR

	@Column(name = "phone")
	private String phone;	//Column data type: VARCHAR


	public Passenger() {
		super();
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

