package models.inputs;

import java.io.Serializable;

public class ChangePassworDto implements Serializable {
    private String password;
    private String retypePassword;

    public ChangePassworDto(String password, String retypePassword) {
        this.password = password;
        this.retypePassword = retypePassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
