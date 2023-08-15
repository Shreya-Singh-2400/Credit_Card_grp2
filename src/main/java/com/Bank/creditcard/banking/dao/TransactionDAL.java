package com.Bank.creditcard.banking.dao;
import com.Bank.creditcard.banking.entity.Transaction;
import java.util.List;

public interface TransactionDAL {

    List<Transaction> getAllTransactions();
    List<Transaction> getAmountsForCity(String city);
    List<Transaction> getAmountsForGender(String gender);
    List<Transaction> getAmountsForCategory(String category);
    List<Transaction> getAmountsForMerchant(String merchant);
    List<Transaction> getAmountsForState(String state);


}
