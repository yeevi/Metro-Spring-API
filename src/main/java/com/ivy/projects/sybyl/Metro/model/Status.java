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
@Table(name="STATUS")
@AllArgsConstructor
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STATUS_ID")
	private int statusId;	//Column data type: INT

	@Column(name = "STATE")
	private String state;	//Column data type: VARCHAR


	public Status() {
		super();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

