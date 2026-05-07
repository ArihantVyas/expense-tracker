package com.arihant.expense_tracker.service;

import com.arihant.expense_tracker.dto.ExpenseRequestDto;
import com.arihant.expense_tracker.dto.ExpenseResponseDto;
import com.arihant.expense_tracker.entity.Expense;
import com.arihant.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void readAll(ExpenseResponseDto responseDto){

        List<Expense> expenseResList = repo.findAll();
        List<ExpenseResponseDto> resDtoList = new ArrayList<>();

        for(Expense expense : expenseResList){

            Expense loopExpenseObject = new Expense();

            loopExpenseObject.setId(expense.getId());
            loopExpenseObject.setTitle(expense.getTitle());
            loopExpenseObject.setCategory(expense.getCategory());
            loopExpenseObject.setType(expense.getType());
            loopExpenseObject.setAmount(expense.getAmount());
            loopExpenseObject.setExpenseDate(expense.getExpenseDate());
            loopExpenseObject.setEntryDateTime(expense.getEntryDateTime());
        }

    }
}
