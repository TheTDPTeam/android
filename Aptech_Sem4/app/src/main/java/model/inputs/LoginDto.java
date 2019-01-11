package model.inputs;

import java.io.Serializable;

public class LoginDto implements Serializable{
    private String Email;
    private String Password;

    public LoginDto(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
