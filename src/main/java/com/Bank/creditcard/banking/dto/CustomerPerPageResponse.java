package com.Bank.creditcard.banking.dto;

import com.Bank.creditcard.banking.entity.Customer;

import java.util.List;
public class CustomerPerPageResponse {

        int totalPages;
        long totalElements;
        int noofelements ;
        int pagesize ;
        List<Customer> customer;

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public int getNoofelements() {
            return noofelements;
        }

        public void setNoofelements(int noofelements) {
            this.noofelements = noofelements;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public List<Customer> getEmployees() {
            return customer;
        }

        public void setCustomer(List<Customer> customer) {
            this.customer = customer;
        }



}
