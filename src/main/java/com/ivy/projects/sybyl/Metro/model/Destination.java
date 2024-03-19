package com.ivy.projects.sybyl.Metro.model;


import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="DESTINATION")
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "D_ID")
	private int dId;	//Column data type: INT

	@Column(name = "D_NAME")
	private String dName;	//Column data type: VARCHAR


	public Destination() {
		super();
	}

	public int getDId() {
		return dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	public String getDName() {
		return dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

}

