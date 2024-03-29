package org.launchcode.StudentPickUpManagement.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotNull
    @Size(min=5, max=15)
    private String username;

    @NotNull
    @Size(min=6,max=15)
    private String password;

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

