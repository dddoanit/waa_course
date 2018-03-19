package cs545.bank.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("accountNumberValidator")
public class AccountNumberValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		FacesMessage msg = new FacesMessage("Account number validation failed", "Account number must be number");
		try {
			long accountNumber = (long) value;
			if (accountNumber <= 0) {
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		} catch (Exception e) {
			throw new ValidatorException(msg);
		}
	}

}
