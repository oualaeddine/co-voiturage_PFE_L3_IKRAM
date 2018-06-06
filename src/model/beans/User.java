package model.beans;

import util.enums.UserType;

public class User extends Person {


    /**
	 * 
	 */
	private static final long serialVersionUID = 762327623399539888L;
	private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
