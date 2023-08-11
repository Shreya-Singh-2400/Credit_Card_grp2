package com.Bank.creditcard.banking.dao;

import com.Bank.creditcard.banking.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

    List<Customer> findCustomersByJob(String job);


}
