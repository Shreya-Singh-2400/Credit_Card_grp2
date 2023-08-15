package com.Bank.creditcard.banking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Customer")
public class Customer {
    @Id
    private String _id;
    @Field("customer_id")
    private long customerId;

    @Field("first")
    private String firstName;

    @Field("last")
    private String lastName;
    private String gender;
    private String job;
    private String dob;

    public Customer(){
    }

    public Customer(int customerId, String firstname, String lastName, String job) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }

    public Customer(String firstName, String lastName, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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



    public String getDob() {
        return dob;
    }



    public void setDob(String dob) {
        this.dob = dob;
    }
}
