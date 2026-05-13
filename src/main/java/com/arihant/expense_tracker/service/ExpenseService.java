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
        expenseReq.setRemark(requestDto.getRemark());

        Expense expenseRes = repo.save(expenseReq);

        return expenseRes;
    }

    public List<ExpenseResponseDto> getAll(){

        List<Expense> expenseResList = repo.findAll();
        List<ExpenseResponseDto> resDtoList = new ArrayList<>();

        for(Expense expense : expenseResList){

            // WRONG LOGIC :-
            // Convert Entity -> DTO.
            // No need to recreate Expense entity because JPA already returns populated entities.

            // Expense loopExpenseObject = new Expense();

            ExpenseResponseDto loopResDto = new ExpenseResponseDto();

            loopResDto.setId(expense.getExpId());
            loopResDto.setTitle(expense.getTitle());
            loopResDto.setCategory(expense.getCategory());
            loopResDto.setType(expense.getType());
            loopResDto.setAmount(expense.getAmount());
            loopResDto.setExpenseDate(expense.getExpenseDate());
            loopResDto.setEntryDateTime(expense.getEntryDateTime());
            loopResDto.setRemark(expense.getRemark());

            resDtoList.add(loopResDto);
        }

        return resDtoList;

    }
}
