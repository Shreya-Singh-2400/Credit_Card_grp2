package com.Bank.creditcard.banking.service;
import com.Bank.creditcard.banking.dao.CustomerRepository;
import com.Bank.creditcard.banking.dto.CustomerPerPageResponse;
import com.Bank.creditcard.banking.entity.Customer;
import com.Bank.creditcard.banking.exceptions.RecordExistsException;
import com.Bank.creditcard.banking.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepository repository;
        public Customer insertCustomer(Customer customer) throws RecordExistsException {
        if(repository.existsById((String) customer.get_id()))
            throw new RecordExistsException("Employee with "+customer.get_id()+"already exists");
        long count = this.repository.count();
        customer.set_id(String.valueOf(count+1));
        Customer savedCustomer = repository.save(customer);
        System.out.printf("There are now %d employees\n", repository.count());
        return  savedCustomer;
    }
    // Get all Customer.
    public List<Customer> getAllCustomers()
    {
        return this.repository.findAll();
    }
    public List<Customer> getCustomerByCustomerId(long _id)
    {
        return repository.findAllByCustomerId(_id);
    }

    public void updateCustomer( Customer custToUpdate) throws RecordNotFoundException {
        System.out.println("UPDATE "+custToUpdate.get_id());
        if(! repository.existsById((String) custToUpdate.get_id()))
            throw new RecordNotFoundException("customer with "+custToUpdate.getCustomerId()+" does not exist");
        repository.save(custToUpdate);
    }
    // Get all customer by job.
    public List<Customer> getAllCustomersByJob(String job) {
        return this.repository.findCustomersByJob(job);
    }

    // Get a page of customers.
    public CustomerPerPageResponse getCustomersByPagination(int pageno, int size) {
        Pageable pageable = PageRequest.of(pageno, size);
        Page<Customer> page = repository.findAll( pageable);
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int noofelements = page.getNumberOfElements();
        int pagesize = page.getSize();
        CustomerPerPageResponse response = new CustomerPerPageResponse();
        response.setCustomer(page.getContent());
        response.setNoofelements(noofelements);
        response.setPagesize(pagesize);
        response.setTotalElements(totalElements);
        response.setTotalPages(totalPages);
        return response;
    }
    public void deleteCustomer(String _id) throws RecordNotFoundException {

        if(repository.existsById(_id))
            throw new RecordNotFoundException("employee with "+_id+" does not exist");
        repository.deleteById(_id);
    }
}
