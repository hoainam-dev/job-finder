package com.jobfinder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class UpgradePackageEntity extends BaseEntity {

	@Column(name = "amount")
	private Long amount;

	@Column(name = "email", columnDefinition = "TEXT")
	private String email;

	@Column(name = "productName", columnDefinition = "TEXT")
	private String productName;

	public long getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public String getProductName() {
		// TODO Auto-generated method stub
		return productName;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
