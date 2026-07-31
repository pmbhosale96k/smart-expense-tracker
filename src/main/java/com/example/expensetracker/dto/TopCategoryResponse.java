package com.example.expensetracker.dto;

import com.example.expensetracker.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TopCategoryResponse {

    private Category category;

    private BigDecimal totalExpense;
}