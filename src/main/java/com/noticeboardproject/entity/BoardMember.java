package com.noticeboardproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardMember {
	
	@Id
	private String userId;
	
	private String userPwd;
	
	private String userName;
	
	private Integer phoneNum;
	
	private String Email;
	
	@CreationTimestamp
	@Column(name="REGDATE")
	private LocalDate regdate;
	
}

