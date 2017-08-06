package app.models.usersDto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersDto {
	
	@XmlElement(name = "user")
	private List<UserDto> users;
	
	@XmlElement(name = "user")
	private List<UserWithSoldProductsDto> successfullUsers;

	public UsersDto() {
		super();
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	public List<UserWithSoldProductsDto> getSuccessfullUsers() {
		return successfullUsers;
	}

	public void setSuccessfullUsers(List<UserWithSoldProductsDto> successfullUsers) {
		this.successfullUsers = successfullUsers;
	}
	
}
