package com.example.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.dto.ExpenseRequest;
import com.example.expensetracker.dto.ExpenseResponse;
import com.example.expensetracker.dto.TopCategoryResponse;
import com.example.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> addExpense(
            @Valid @RequestBody ExpenseRequest request) {

        ExpenseResponse response = service.addExpense(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getExpenses(
            @RequestParam(required = false) String category) {

        if (category == null) {
            return ResponseEntity.ok(service.getAllExpenses());
        }

        return ResponseEntity.ok(service.getExpensesByCategory(category));

    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary(

            @RequestParam(required = false) String category) {

        if (category == null) {
            return ResponseEntity.ok(service.getOverallSummary());
        }

        return ResponseEntity.ok(
                service.getCategorySummary(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {

        service.deleteExpense(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExpenseResponse>> searchExpenses(
            @RequestParam String keyword) {

        return ResponseEntity.ok(service.searchExpense(keyword));
    }

    @GetMapping("/analytics/top-category")
    public ResponseEntity<TopCategoryResponse> getTopCategory() {

        return ResponseEntity.ok(
                service.getTopSpendingCategory());
    }

}
