package com.nttdata.bean;

import java.util.Date;

import com.nttdata.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAccount {

	int id;
	String clientId;
	String productId;
	String accountNumber;
}
