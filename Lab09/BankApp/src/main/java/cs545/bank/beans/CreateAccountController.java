package cs545.bank.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("account")
public class CreateAccountController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CacheManagerBean cacheManagerBean;
	
	String name;
	long accountNumber;
	
	double deposit;
	
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String createAccount() {
		cacheManagerBean.create(name, accountNumber);
		cacheManagerBean.getService().deposit(accountNumber, deposit);
		return "success";
	}
	
	public void validateDeposit(FacesContext context, UIComponent comp,
			Object value) {
		double depositVal = (double)value;
		if (depositVal < 0) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"The deposit must be positive and greater than zero.");
			context.addMessage(comp.getClientId(context), message);
		}
	}
	
}
