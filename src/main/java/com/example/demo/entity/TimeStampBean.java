package com.example.demo.entity;

import java.sql.Timestamp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeStampBean {
	private int id;
	private String name;
	private Timestamp time;
}
