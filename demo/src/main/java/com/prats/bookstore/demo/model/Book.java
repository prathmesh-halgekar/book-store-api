package com.prats.bookstore.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(nullable = false)
	private String id;

	@Getter
	@Setter
	@Column(nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(nullable = false)
	private String details;

	@Getter
	@Setter
	@Column(nullable = false)
	private Double price;

	@Getter
	@Setter
	@Column(nullable = false)
	private String image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
