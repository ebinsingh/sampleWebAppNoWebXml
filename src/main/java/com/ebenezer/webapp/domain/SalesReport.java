package com.ebenezer.webapp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salesreport database table.
 * 
 */
@Entity
@Table(name="salesreport")
@NamedQuery(name="SalesReport.findAll", query="SELECT s FROM SalesReport s")
public class SalesReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "Product_Name")
	private String productName;

	public SalesReport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesReport other = (SalesReport) obj;
		if (id != other.id)
			return false;
		return true;
	}

}