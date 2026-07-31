package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ExpenseRepository {

    private final ConcurrentHashMap<Long, Expense> expenseMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Expense save(Expense expense) {
        if (expense.getId() == null) {
            expense.setId(idGenerator.getAndIncrement());
        }
        expenseMap.put(expense.getId(), expense);
        return expense;
    }

    public List<Expense> findAll() {
        return new ArrayList<>(expenseMap.values());
    }

    public Optional<Expense> findById(Long id) {
        return Optional.ofNullable(expenseMap.get(id));
    }

    public void deleteById(Long id) {
        expenseMap.remove(id);
    }

    public boolean existsById(Long id) {
        return expenseMap.containsKey(id);
    }
    
}