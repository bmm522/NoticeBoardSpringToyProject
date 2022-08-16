package com.noticeboardproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardMember {
	
	
	@Column(name="EMAIL")
	private String email;
	@CreationTimestamp
	@Column(name="REGDATE")
	private LocalDate regdate = LocalDate.now();
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="PHONENUM")
	private Integer phoneNum;
	@Column(name="USERID")
	private String userId;
	@Column(name="USERNAME")
	private String userName;
	@Column(name="USERPWD")
	private String userPwd;
	
	
	
	
	public BoardMember() {}
	
	
	

	public BoardMember(String userId, String userPwd, String userName, Integer phoneNum, String email) {
		
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	
	
}

