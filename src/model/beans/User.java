package model.beans;

import util.enums.UserType;

public class User extends Person {


    /**
	 * 
	 */
	private static final long serialVersionUID = 762327623399539888L;
	private UserType userType;
	private String typeClient;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
}
