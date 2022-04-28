package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="booking")

public class bookingmodel  
{

	public bookingmodel(bookingmodel bookingModel) {
		// TODO Auto-generated constructor stub
	}
	@Id
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue
	
	@Column(name="id")
	@NotNull(message="Id required")
	private long id;
	
	@Column(name="groundName")
	@NotBlank(message = "Ground name required")
	private String groundName;
	@NotBlank(message = "Ground name required")
	@Column(name="address")
	private String  address;
	@NotBlank(message = "No of persons field required")
	@Column(name="noOfPersons")
	private  String noOfPersons;
	
	@NotBlank(message = "From Date required")
	@Column(name="fromDate")
	private String fromDate;
	@NotBlank(message = "To Date required")
	@Column(name="toDate")
	private String toDate;
	@NotBlank(message = "Total price required")
	@Column(name="totalProce")
	private String totalPrice;
	
@JsonBackReference
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="user_Id",referencedColumnName="id" )
private usermodel user;
	
}
