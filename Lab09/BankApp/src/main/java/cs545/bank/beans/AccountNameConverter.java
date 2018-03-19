package cs545.bank.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("accountNameConverter")
public class AccountNameConverter implements Converter{
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("AccountNameConverter.getAsString()");
		return (String)value;
	}
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("AccountNameConverter.getAsObject()");
		return value;
	}
	
}
