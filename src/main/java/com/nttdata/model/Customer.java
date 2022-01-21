package com.nttdata.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	int id;
    String name;
    String companyName;
    String lastname;
    String documentType;
    String documentNumber;
    String phoneNumber;
    String email;
    String clientType;
}
