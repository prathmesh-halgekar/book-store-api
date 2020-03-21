package com.prats.bookstore.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Getter
	@Setter
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String username;

	@Getter
	@Setter
	@Column(nullable = false)
	private String password;

	@Getter
	@Setter
	@Column(name = "IS_ACTIVE", nullable = false)
	private boolean active;

	@Getter
	@Setter
	@Column(nullable = false)
	private String image;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
