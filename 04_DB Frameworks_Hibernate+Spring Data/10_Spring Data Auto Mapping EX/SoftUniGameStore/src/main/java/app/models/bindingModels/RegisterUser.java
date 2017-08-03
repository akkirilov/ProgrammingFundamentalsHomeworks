package app.models.bindingModels;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

	private String fullName;
	
	@Pattern(regexp=".+@.+\\..+", message = "Incorrect email!")
	private String email;
	
	@Size(min = 6, message = "Password length must be at least 6 symbols!")
	private String password;
	
	public RegisterUser() {
		super();
	}

	public RegisterUser(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
