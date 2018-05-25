package model.beans;

import util.enums.UserType;

public class User extends Person {


    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
