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
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}