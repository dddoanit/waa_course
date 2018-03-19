package cs545.bank.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("accountNameValidator")
public class AccountNameValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String accountName = (String) value;
		if (accountName == null || accountName.isEmpty()) {
			FacesMessage msg = new FacesMessage("Account Name Validation failed", "Account name is required");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			throw new ValidatorException(msg);
		}
	}

}
