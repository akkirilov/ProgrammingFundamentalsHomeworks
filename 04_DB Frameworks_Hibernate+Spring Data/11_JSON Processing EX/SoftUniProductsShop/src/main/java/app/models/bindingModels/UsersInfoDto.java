package app.models.bindingModels;

import java.io.Serializable;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class UsersInfoDto implements Serializable {

	private static final long serialVersionUID = -2728140800407971128L;

	@Expose
	private Integer userCount;
	
	@Expose
	Set<UserProductsInfoDto> users;

	public UsersInfoDto() {
		super();
	}

	public UsersInfoDto(Integer userCount, Set<UserProductsInfoDto> users) {
		super();
		this.userCount = userCount;
		this.users = users;
	}

	public Integer getUserCount() {
		return users.size();
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Set<UserProductsInfoDto> getUsers() {
		return users;
	}

	public void setUsers(Set<UserProductsInfoDto> users) {
		this.users = users;
	}
	
}
