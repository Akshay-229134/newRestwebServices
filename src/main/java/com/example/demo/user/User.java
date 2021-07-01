package com.example.demo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	//@Size(min=2,message="Name should have 2 char")
	private String name;	
	//@Past
	private Date birthdate;

	//As 1 user can have multiple posts,
	//and 1 post can have 1user only
	
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	protected User() {

	}

	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", birthdate=" + birthdate + "]";
	}
}
