package com.example.form.model;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự")
    private String lastName;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private int age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    public @NotBlank(message = "Họ không được để trống") @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Họ không được để trống") @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Tên không được để trống") @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Tên không được để trống") @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự") String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Số điện thoại không hợp lệ") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Số điện thoại không hợp lệ") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "Tuổi phải từ 18 trở lên") int age) {
        this.age = age;
    }

    public @NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email không được để trống") @Email(message = "Email không hợp lệ") String email) {
        this.email = email;
    }
}
