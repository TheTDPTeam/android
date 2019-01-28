package models.outputs;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private String imageUrl;
    private String name;
    private String phone;
    private String email;

    public EmployeeDto() {
    }

    public EmployeeDto(String imageUrl, String name, String phone, String mail) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.phone = phone;
        this.email = mail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }
}
