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
@Table(name="vehicles")
public class vehiclemodel {
	
	
	public vehiclemodel(vehiclemodel bookingModel)
	{
		// TODO Auto-generated constructor stub
	}
	@Id
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue
	
	@Column(name="id")
	@NotNull(message="Id required")
	private long id;
	
	@Column(name="vehicleID")
	@NotBlank(message = "Vehicle id required")
	private String vehicleId;
	
	@NotBlank(message = "Vehicle name required")
	@Column(name="vehicleName")
	private String  vehicleName;
	
	@NotBlank(message = "VehicleImageUrl required")
	@Column(name="vehicleImageURL")
	private String vehicleImageURL;
	
	@NotBlank(message = "VehicleAddress required")
	@Column(name="VehicleAdress")
	private String VehicleAdress;
	
	@NotBlank(message = "Vehicle Description is  required")
	@Column(name="VehicleDescription")
	private String VehicleDescription;
	
	@NotBlank(message = "Vehicle available status required")
	@Column(name="vehicleAvailableStatus")
	private String vehicleAvailableStatus;
	
	@NotBlank(message = "Vehicle available price required")
	@Column(name="Price")
	private String Price;
	
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_Id",referencedColumnName="id" )
	private usermodel user1;
	
}
