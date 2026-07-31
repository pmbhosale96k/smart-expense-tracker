package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseRequest;
import com.example.expensetracker.dto.ExpenseResponse;
import com.example.expensetracker.exception.ExpenseNotFoundException;
import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseResponse addExpense(ExpenseRequest request) {
        Category expenseCategory = Category.valueOf(request.getCategory().trim().toUpperCase());

        Expense expense = Expense.builder()
                .title(request.getTitle())
                .amount(request.getAmount())
                .category(expenseCategory)
                .date(request.getDate())
                .build();

        Expense savedExpense = repository.save(expense);

        return mapToResponse(savedExpense);
    }

    @Override
    public List<ExpenseResponse> getAllExpenses() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseResponse> getExpensesByCategory(String category) {

        Category expenseCategory = Category.valueOf(category.trim().toUpperCase());

        return repository.findAll()
                .stream()
                .filter(expense -> expense.getCategory() == expenseCategory)
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> getOverallSummary() {
    List<Expense> expenses = repository.findAll();

    BigDecimal total = expenses.stream()
            .map(Expense::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    return Map.of(
            "totalExpense", total,
            "totalRecords", expenses.size()
    );
}

    @Override
    public Map<String, Object> getCategorySummary(String category) {

        Category expenseCategory = Category.valueOf(category.toUpperCase());

        BigDecimal total = repository.findAll()
                .stream()
                .filter(expense -> expense.getCategory() == expenseCategory)
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "category", expenseCategory,
                "totalExpense", total);
    }

    @Override
    public void deleteExpense(Long id) {

        if (!repository.existsById(id)) {
            throw new ExpenseNotFoundException(id);
        }

        repository.deleteById(id);
    }

    private ExpenseResponse mapToResponse(Expense expense) {

        return ExpenseResponse.builder()
                .id(expense.getId())
                .title(expense.getTitle())
                .amount(expense.getAmount())
                .category(expense.getCategory())
                .date(expense.getDate())
                .build();
    }

}