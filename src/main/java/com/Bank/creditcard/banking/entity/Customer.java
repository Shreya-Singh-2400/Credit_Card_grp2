package com.Bank.creditcard.banking.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
public class Customer {
    @Id
    private long customer_id;
    private String firstName;
    private String lastName;
    private String gender;
    private String job;
    private Date dob;

    public Customer(int customer_id, String firstname, String lastName, String job) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }
    public Customer(String firstName, String lastName, String job) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }


    public int getCustomer_id() {
        return (int) customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getJob() {
        return job;
    }



    public void setJob(String job) {
        this.job = job;
    }



    public Date getDob() {
        return dob;
    }



    public void setDob(Date dob) {
        this.dob = dob;
    }
}
