package com.noticeboardproject.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity(name ="TALBELIST")
@Getter
@Setter
public class TableList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String writer_id;
	
	private String content;
	
	private Date regdate;
	
	private Integer hit;
	
	private String files;
	
	private Integer pub;
}
