package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseRequest;
import com.example.expensetracker.dto.ExpenseResponse;
import com.example.expensetracker.dto.TopCategoryResponse;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    
    TopCategoryResponse getTopSpendingCategory();

    ExpenseResponse addExpense(ExpenseRequest request);


    List<ExpenseResponse> getAllExpenses();

    List<ExpenseResponse> getExpensesByCategory(String category);

    Map<String, Object> getOverallSummary();

    Map<String, Object> getCategorySummary(String category);

    List<ExpenseResponse> searchExpense(String keyword);

    void deleteExpense(Long id);


}