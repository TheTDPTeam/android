package model.outputs;

import java.io.Serializable;

public class LoginReponse implements Serializable {
    private String email;
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}