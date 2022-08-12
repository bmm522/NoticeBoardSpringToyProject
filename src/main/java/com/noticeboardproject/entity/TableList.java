package com.noticeboardproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

//@Table(name="TABLELIST")
@Entity
@Getter
@Setter
public class TableList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="HIT")
	private Integer hit = 0;	
	
	@Column(name="PUB")
	private Integer pub = 1;
	
	@CreationTimestamp
	@Column(name="REGDATE")
	private LocalDate regdate;
	
	private String title;
	
	
	private String writer_id;
	
	
	private String content;
	
	
	private String files;
	

	
}
