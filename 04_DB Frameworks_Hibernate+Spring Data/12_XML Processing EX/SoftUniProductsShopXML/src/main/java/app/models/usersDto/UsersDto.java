package app.models.usersDto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersDto {

	@Expose
	@XmlElement(name = "user")
	private List<UserDto> users;

	@Expose
	@XmlElement(name = "user")
	private List<UserWithSoldProductsDto> successfullUsers;

	@Expose
	@XmlElement(name = "user")
	private List<UserWithProductsInfoDto> userWithProductsInfo;

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

	public List<UserWithProductsInfoDto> getUserWithProductsInfo() {
		return userWithProductsInfo;
	}

	public void setUserWithProductsInfo(List<UserWithProductsInfoDto> userWithProductsInfo) {
		this.userWithProductsInfo = userWithProductsInfo;
	}
	
}
