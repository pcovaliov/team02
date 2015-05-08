package com.endava.endavainternship.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

@Entity
@Table(name = "UserTable")
public class User extends org.springframework.security.core.userdetails.User
		implements Serializable {
	
	

	public User() {
		super("Anonimous", "", true, true, true, true,
				new ArrayList<GrantedAuthority>());
	};

	public User(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}
	
	

	@Id
	@Column(name = "UserID")
	@GeneratedValue
	private Integer id;

	@NotEmpty
	@Column(name = "FirstName", nullable = false)
	private String firstname;

	@NotEmpty
	@Column(name = "LastName")
	private String lastname;

	@NotEmpty
	@Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)"
			+ "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)"
			+ "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)"
			+ "+(?:[a-zA-Z]){2,}\\.?)$", message = "Invalid email")
	@Column(name = "email")
	private String email;
	
	@Column(name = "Role" , nullable = false, columnDefinition="varchar(15) default 'ROLE_USER'")
	private String role = "ROLE_USER";
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE)
	private Collection<Tweet> tweets = new ArrayList<Tweet>();
	
	public String getRole(){
		return role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//security related
		public Collection<GrantedAuthority> getAuthorities() {
			Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl(this.role));
			return authorities;
		}

	    public boolean isAccountNonExpired() { return true;}
	    public boolean isAccountNonLocked() { return true; }
	    public boolean isCredentialsNonExpired() {return true; }
	    public boolean isEnabled() { return true;}
	
	

}
