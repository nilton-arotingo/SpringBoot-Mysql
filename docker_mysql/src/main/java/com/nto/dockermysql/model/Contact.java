package com.nto.dockermysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Column(name="username")
	private String username;

	@NotNull
	@Column(name="cellphone")
	private Integer cellphone;

	public Contact() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCellphone() {
		return cellphone;
	}

	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}

}
