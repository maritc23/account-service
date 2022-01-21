package com.nttdata.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nttdata.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAccountResult {

	String accountId;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date createAt;
	String accountNumber;
}
