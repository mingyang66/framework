package models;

import java.util.Date;

import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.Required;
import play.templates.JavaExtensions;

public class User {

	@Required
	private String username;
	
	@Required
	@CheckWith(MyPasswordCheck.class)
	private String password;
	
	static class MyPasswordCheck extends Check{

		 public boolean isSatisfied(Object user, Object password) {
			 final Date lastUsed = new Date();
		        setMessage("validation.password", JavaExtensions.format(lastUsed));
		        return false;
		    }
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
