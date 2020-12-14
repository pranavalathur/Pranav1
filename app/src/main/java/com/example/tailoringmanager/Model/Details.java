package com.example.tailoringmanager.Model;


public class Details
{
    private String Course1,Course2,Email,Firstname,Lastname,Phone;
    public Details(){

    }

    public Details(String Course1,String Course2,String Email,String Firstname,String Lastname,String Phone) {
        this.Course1 = Course1;
        this.Course2 = Course2;
        this.Email = Email;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Phone = Phone;
    }

    public String getCourse1() {
        return Course1;
    }

    public void setCourse1(String course1) {
        Course1 = course1;
    }

    public String getCourse2() {
        return Course2;
    }

    public void setCourse2(String course2) {
        Course2 = course2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
