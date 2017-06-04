package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bean {
	private int id;
	private String name;
	private String time;

	public Bean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
