package com.endava.twitter.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_table")
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "avatar")
	private String avatar;

	public String getEmail() {
		return email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
