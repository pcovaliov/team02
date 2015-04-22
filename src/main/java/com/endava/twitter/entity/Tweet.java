package com.endava.twitter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tweets_table")
public class Tweet {

	@Id
	@Column(name = "ID_T")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private String created_date;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}