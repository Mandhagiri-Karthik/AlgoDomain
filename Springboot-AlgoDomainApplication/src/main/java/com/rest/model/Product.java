package com.rest.model;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

	@Entity
	public class Product {
	@Id
	private int pid;
	private String pname;
	private String ptype;
	private String pcategory;
	private double price;
	@Embedded
	private Charges charges;
	public Product() {
		super();
	}
	public Product(int pid, String pname, String ptype, String pcategory, double price, Charges charges) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pcategory = pcategory;
		this.price = price;
		this.charges = charges;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Charges getCharges() {
		return charges;
	}
	public void setCharges(Charges charges) {
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pcategory=" + pcategory + ", price="
				+ price + ", charges=" + charges + "]";
	}
	
}
