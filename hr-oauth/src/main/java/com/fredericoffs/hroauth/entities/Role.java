package com.fredericoffs.hroauth.entities;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String roleName;

	public Role() {
	}

	public Role(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return roleName;
	}

	public void setName(String roleName) {
		this.roleName = roleName;
	}

}
