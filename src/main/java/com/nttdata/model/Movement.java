package com.nttdata.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movement {
	private String id;
	private String ammout;
	private String type;
	private Date date;
}
