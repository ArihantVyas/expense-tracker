package com.arihant.expense_tracker.controller;

import com.arihant.expense_tracker.dto.ExpenseRequestDto;
import com.arihant.expense_tracker.entity.Expense;
import com.arihant.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/")
    public ResponseEntity<Expense> saveNewEntry(@RequestBody @Valid ExpenseRequestDto expenseRequestDto){
        Expense exp = expenseService.saveNewEntry(expenseRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(exp);
    }
}
