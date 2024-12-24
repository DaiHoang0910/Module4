package com.example.form.model;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự")
    private String firstname;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự")
    private String lastname;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Số điện thoại không hợp lệ")
    private String phonenumber;

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private int age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
