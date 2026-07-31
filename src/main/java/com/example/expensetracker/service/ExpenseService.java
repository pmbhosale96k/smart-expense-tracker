package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseRequest;
import com.example.expensetracker.dto.ExpenseResponse;

import java.util.List;
import java.util.Map;

public interface ExpenseService {

    ExpenseResponse addExpense(ExpenseRequest request);


    List<ExpenseResponse> getAllExpenses();

    List<ExpenseResponse> getExpensesByCategory(String category);

    Map<String, Object> getOverallSummary();

    Map<String, Object> getCategorySummary(String category);

    void deleteExpense(Long id);


}