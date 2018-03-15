package edu.mum.cs545;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Pizza;

@Named
@ApplicationScoped
public class PizzaOrderHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	List<String> pizzaList = new ArrayList<String>();

	@PostConstruct
	public void init() {
		pizzaList.add("NY Cheese Pizza");
		pizzaList.add("Indian Spicy Pizza");
		pizzaList.add("Italian Special Pizza");
	}

	public List<String> getPizzaList() {
		return pizzaList;
	}

	public String test() {
		return null;
	}

	public void addPizza(Order order) {
		Pizza p = new Pizza();
		p.setEditable(true);
		order.addPizza(p);
	}

	public void deletePizza(Order order, Pizza pizza) {
		order.removePizza(pizza);
	}

	public void changeEditStatus(Pizza pizza) {
		pizza.setEditable(!pizza.isEditable());
	}

	public boolean valid(Order order) {
		if ((order.getPizzaList().size() == 0) 
				|| (order.getCustomer().getFirstName() == null) 
				|| (order.getCustomer().getFirstName().isEmpty())) {
			return false;
		}
		for (Pizza p : order.getPizzaList()) {
			if (p.isEditable()) {
				return false;
			}
		}
		return true;
	}

	public boolean hasComplementaryDrinks(Order order) {
		boolean found = false;
		for (Pizza pizza : order.getPizzaList()) {
			if ("Indian Spicy Pizza".equals(pizza.getName())) {
				found = true;
				break;
			}
		}
		return found;
	}

	public String submitOrder(Order order) {

		System.out.println(
				String.format("***==> Customer: fist=[%s] last=[%s] email=[%s]", order.getCustomer().getFirstName(),
						order.getCustomer().getLastName(), order.getCustomer().getEmailAddress()));

		StringBuilder items = new StringBuilder();
		items.append("***==> Order: ");
		for (Pizza p : order.getPizzaList()) {
			items.append(p.getQuantity() + " " + p.getName() + "|");
		}
		if (order.isComplimentaryDrink()) {
			items.append("Complementary Drink");
		}
		System.out.println(items.toString());

		return "success";
	}

}
