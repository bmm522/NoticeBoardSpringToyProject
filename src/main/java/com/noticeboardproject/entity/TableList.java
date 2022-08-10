package com.noticeboardproject.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	private String title;
	
	private String writer_id;
	
	private Date regdate;
	
	private Integer hit;
		
	private Integer pub;
}
