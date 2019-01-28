package models.inputs;

import java.io.Serializable;

public class LoginDto implements Serializable{
    private String email;
    private String password;

    public LoginDto(String _email, String _password) {
        this.email = _email;
        this.password = _password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
