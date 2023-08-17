package com.Bank.creditcard.banking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document(collection = "Customer")
public class Customer {
    @Id
    private String _id;

    @Field("customer_id")
    private long customerId;

    @NotEmpty(message = "First name is mandatory")
    @Size(min = 2, max = 50, message = "First name should be between 2 and 50 characters")
    @Field("first")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    @Size(min = 2, max = 50, message = "Last name should be between 2 and 50 characters")
    @Field("last")
    private String lastName;

    @NotEmpty(message = "Gender is mandatory")
    private String gender;

    @NotEmpty(message = "Job is mandatory")
    private String job;

    @Past(message = "DOB must be a past date")
    private LocalDate dob;  // Assuming you want to use a more appropriate type than String

    public Customer(){
    }

    // ... (rest of your class)

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
