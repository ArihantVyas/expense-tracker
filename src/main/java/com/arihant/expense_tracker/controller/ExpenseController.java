package com.arihant.expense_tracker.controller;

import com.arihant.expense_tracker.dto.ExpenseRequestDto;
import com.arihant.expense_tracker.dto.ExpenseResponseDto;
import com.arihant.expense_tracker.entity.Expense;
import com.arihant.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create-exp")
    public ResponseEntity<Expense> saveNewEntry(@RequestBody @Valid ExpenseRequestDto expenseRequestDto){
        Expense exp = expenseService.saveNewEntry(expenseRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(exp);
    }

    @GetMapping("/get-exp")
    public ResponseEntity<List<ExpenseResponseDto>>  getAll(){
        return new ResponseEntity<>(expenseService.getAll(),HttpStatus.OK);
    }
}
