package models.outputs;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private String imageUrl;
    private String fullName;
    private String phoneNumber;
    private String email;

    public EmployeeDto() {
    }

    public EmployeeDto(String imageUrl, String name, String phone, String mail) {
        this.imageUrl = imageUrl;
        this.fullName = name;
        this.phoneNumber = phone;
        this.email = mail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }
}
