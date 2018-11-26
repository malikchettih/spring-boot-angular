package com.gmail.malikchettih.springcloud.angular.bikes.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="bike")
@ApiModel(description = "Class representing a bike tracked by the application.")
public class Bike {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Unique identifier of the bike. No two bikes can have the same id.", example = "1", required = true, position = 0)
	private Long id;
	
	@NotBlank
    @Size(min = 1, max = 20)
	@ApiModelProperty(notes = "Name of the bike.", example = "Globo MTB 29 Full Suspension", required = true, position = 1)
	private String name;
	
	@ApiModelProperty(notes = "Email of the owner.", required = true, position = 2)
	private String email;
	@ApiModelProperty(notes = "Phone of the owner.", required = true, position = 3)
	private String phone;
	@ApiModelProperty(notes = "Model of the bike.", required = true, position = 4)
	private String model;
	@ApiModelProperty(notes = "Serial Number of the bike.", required = true, position = 5)
	private String serialNumber;
	@ApiModelProperty(notes = "Purchase price of the bike.", required = true, position = 6)
	private BigDecimal purchasePrice;
	@ApiModelProperty(notes = "Purshace date of the bike.", required = true, position = 7)
	private Date purchaseDate;
	@ApiModelProperty(notes = "Contact.", required = true, position = 8)
	private boolean contact;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public boolean isContact() {
		return contact;
	}
	public void setContact(boolean contact) {
		this.contact = contact;
	}

}
