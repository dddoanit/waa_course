package edu.mum.cs545.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Order implements Serializable {
	private static final long serialVersionUID = 7187645190789626221L;
	
	private Customer customer = new Customer();
    private List<Pizza> pizzaList = new ArrayList<Pizza>();
    private boolean complimentaryDrink;
    
	public boolean isComplimentaryDrink() {
		return complimentaryDrink;
	}
	public void setComplimentaryDrink(boolean complimentaryDrink) {
		this.complimentaryDrink = complimentaryDrink;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer cust) {
		this.customer = cust;
	}
	public List<Pizza> getPizzaList() {
		return Collections.unmodifiableList(pizzaList);
	}
	public void addPizza(Pizza pizza) {
		pizzaList.add(pizza);
	}
	public void removePizza(Pizza pizza) {
		pizzaList.remove(pizza);
	}
	public void clearPizzas() {
		pizzaList.clear();	
	}
	
}
