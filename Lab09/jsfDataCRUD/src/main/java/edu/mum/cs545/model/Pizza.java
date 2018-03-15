package edu.mum.cs545.model;

import java.io.Serializable;

public class Pizza implements Serializable {
	
	private static final long serialVersionUID = -1329498475927178643L;
	private String name;
	private int quantity = 1;
	private boolean editable;
	
	public Pizza() {
		super();
	}
	
	public Pizza(Pizza pizza) {
		super();
		this.name = pizza.name;
		this.quantity = pizza.quantity;
	}
	
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editStatus) {
		this.editable = editStatus;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
