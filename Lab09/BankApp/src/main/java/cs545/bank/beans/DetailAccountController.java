package cs545.bank.beans;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.bank.domain.Account;

@Named
//@RequestScoped
@ViewScoped
public class DetailAccountController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long accountNumber;
	
	private double amount;
	
	private double withdrawn;
	
	private Account account;
	
	@Inject
	private CacheManagerBean cacheManagerBean;
	
	public void loadAccount() {
		if (accountNumber != 0 && account == null) {
			account = cacheManagerBean.getAccount(accountNumber);
		}
	}
	
	public Account getAccount() {
		return account;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void depositListener() {
		cacheManagerBean.getService().deposit(accountNumber, amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void withdrawnListener() {
		cacheManagerBean.getService().withdraw(accountNumber, withdrawn);;
	}

	public double getWithdrawn() {
		return withdrawn;
	}

	public void setWithdrawn(double withdrawn) {
		this.withdrawn = withdrawn;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
