package com.Bank.creditcard.banking.dao;

import com.Bank.creditcard.banking.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import java.util.List;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionDALMongoTemplate implements TransactionDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Transaction> getAllTransactions() {
        return mongoTemplate.findAll(Transaction.class);
    }

    @Override
    public List<Transaction> getAmountsForCity(String city) {
        GroupOperation groupByCitySumAmounts = group("city").sum("amt").as("total_amount");
        MatchOperation allCities = match(new Criteria("city").exists(true));
        ProjectionOperation includes = project("total_amounts").and("city").previousOperation();
        SortOperation sortByAmountsDesc = sort(Sort.by(Sort.Direction.DESC, "total_amounts"));
        Aggregation aggregation = newAggregation(allCities, groupByCitySumAmounts, sortByAmountsDesc, includes);
        AggregationResults<Transaction> groupResults = mongoTemplate.aggregate(aggregation, "Transaction", Transaction.class);
        List<Transaction> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<Transaction> getAmountsForGender(String gender) {
        GroupOperation groupByGenderSumAmounts = group("gender").sum("amt").as("total_amount");
        MatchOperation allGenders = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("total_amounts").and("gender").previousOperation();
        SortOperation sortByAmountsDesc = sort(Sort.by(Sort.Direction.DESC, "total_amounts"));
        Aggregation aggregation = newAggregation(allGenders, groupByGenderSumAmounts, sortByAmountsDesc, includes);
        AggregationResults<Transaction> groupResults = mongoTemplate.aggregate(aggregation, "Transaction", Transaction.class);
        List<Transaction> result = groupResults.getMappedResults();
        return result;
    }
//charts.js, plotly.js, d3.js
    @Override
    public List<Transaction> getAmountsForCategory(String category) {
        GroupOperation groupByCategorySumAmounts = group("category").sum("amt").as("total_amount");
        MatchOperation allCategories = match(new Criteria("category").exists(true));
        ProjectionOperation includes = project("total_amounts").and("category").previousOperation();
        SortOperation sortByAmountsDesc = sort(Sort.by(Sort.Direction.DESC, "total_amounts"));
        Aggregation aggregation = newAggregation(allCategories, groupByCategorySumAmounts, sortByAmountsDesc, includes);
        AggregationResults<Transaction> groupResults = mongoTemplate.aggregate(aggregation, "Transaction", Transaction.class);
        List<Transaction> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<Transaction> getAmountsForMerchant(String merchant) {
        GroupOperation groupByMerchantSumAmounts = group("merchant").sum("amt").as("total_amount");
        MatchOperation allMerchants = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("total_amounts").and("merchant").previousOperation();
        SortOperation sortByAmountsDesc = sort(Sort.by(Sort.Direction.DESC, "total_amounts"));
        Aggregation aggregation = newAggregation(allMerchants, groupByMerchantSumAmounts, sortByAmountsDesc, includes);
        AggregationResults<Transaction> groupResults = mongoTemplate.aggregate(aggregation, "Transaction", Transaction.class);
        List<Transaction> result = groupResults.getMappedResults();
        return result;
    }

    @Override
    public List<Transaction> getAmountsForState(String state) {
        GroupOperation groupByStateSumAmounts = group("state").sum("amt").as("total_amount");
        MatchOperation allStates = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("total_amounts").and("state").previousOperation();
        SortOperation sortByAmountsDesc = sort(Sort.by(Sort.Direction.DESC, "total_amounts"));
        Aggregation aggregation = newAggregation(allStates, groupByStateSumAmounts, sortByAmountsDesc, includes);
        AggregationResults<Transaction> groupResults = mongoTemplate.aggregate(aggregation, "Transaction", Transaction.class);
        List<Transaction> result = groupResults.getMappedResults();
        return result;
    }

}


