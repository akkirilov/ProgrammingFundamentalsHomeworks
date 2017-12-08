package p02_ExtendedDatabase;

import p02_ExtendedDatabase.interfaces.People;

public class PeopleImpl implements People {
	
	private Long id;
	private String username;

	public PeopleImpl(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

}
