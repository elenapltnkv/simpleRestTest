package models.pojo;

public class LoginBodyPojoModel {
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String email;

    private String password;
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
