package com.arihant.expense_tracker.service;

import com.arihant.expense_tracker.dto.ExpenseRequestDto;
import com.arihant.expense_tracker.entity.Expense;
import com.arihant.expense_tracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public Expense saveNewEntry(ExpenseRequestDto requestDto){
        Expense expenseReq = new Expense();

        expenseReq.setTitle(requestDto.getTitle());
        expenseReq.setCategory(requestDto.getCategory());
        expenseReq.setType(requestDto.getType());
        expenseReq.setAmount(requestDto.getAmount());
        expenseReq.setExpenseDate(requestDto.getExpenseDate());

        Expense expenseRes = repo.save(expenseReq);

        return expenseRes;
    }
}
