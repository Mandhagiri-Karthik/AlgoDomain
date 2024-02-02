package com.rest.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Component
@Embeddable
public class Charges {
	
	private String pcategory1;
	private double discount;
	private double gst;
	private double delivery_charges;
	
	public Charges() {
		super();
	}

	public Charges(String pcategory1, double discount, double gst, double delivery_charges) {
		super();
		this.pcategory1 = pcategory1;
		this.discount = discount;
		this.gst = gst;
		this.delivery_charges = delivery_charges;
	}

	public String getPcategory1() {
		return pcategory1;
	}

	public void setPcategory1(String pcategory1) {
		this.pcategory1 = pcategory1;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDelivery_charges() {
		return delivery_charges;
	}

	public void setDelivery_charges(double delivery_charges) {
		this.delivery_charges = delivery_charges;
	}

	@Override
	public String toString() {
		return "Charges [pcategory1=" + pcategory1 + ", discount=" + discount + ", gst=" + gst + ", delivery_charges="
				+ delivery_charges + "]";
	}
	
	
	
}
