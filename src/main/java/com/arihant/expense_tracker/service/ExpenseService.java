package com.arihant.expense_tracker.service;

import com.arihant.expense_tracker.dto.ExpenseRequestDto;
import com.arihant.expense_tracker.dto.ExpenseResponseDto;
import com.arihant.expense_tracker.entity.Expense;
import com.arihant.expense_tracker.entity.User;
import com.arihant.expense_tracker.exception.ResourceNotFoundException;
import com.arihant.expense_tracker.repository.ExpenseRepository;
import com.arihant.expense_tracker.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final UserRepository userRepo;

    public ExpenseService(ExpenseRepository expenseRepo,UserRepository userRepo) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
    }

    private User getAuthenticatedUser(){

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String username = authentication.getName();

        return userRepo.findByUsername(username)
                .orElseThrow();

    }

    public ExpenseResponseDto saveNewEntry(ExpenseRequestDto requestDto){

        Expense newExp = new Expense();

        newExp.setTitle(requestDto.getTitle());
        newExp.setCategory(requestDto.getCategory());
        newExp.setType(requestDto.getType());
        newExp.setAmount(requestDto.getAmount());
        newExp.setExpenseDate(requestDto.getExpenseDate());
        newExp.setRemark(requestDto.getRemark());

        newExp.setUser(getAuthenticatedUser());

        Expense expenseRes = expenseRepo.save(newExp);
        ExpenseResponseDto responseDto = new ExpenseResponseDto();

        responseDto.setId(expenseRes.getExpId());
        responseDto.setTitle(expenseRes.getTitle());
        responseDto.setCategory(expenseRes.getCategory());
        responseDto.setType(expenseRes.getType());
        responseDto.setAmount(expenseRes.getAmount());
        responseDto.setRemark(expenseRes.getRemark());
        responseDto.setEntryDateTime(expenseRes.getEntryDateTime());
        responseDto.setExpenseDate(expenseRes.getExpenseDate());

        return responseDto;
    }

    public List<ExpenseResponseDto> getAll(){

        List<Expense> expenseResList = expenseRepo.findByUser(getAuthenticatedUser());
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

    public String deleteExpense(Long expId){
        User user = getAuthenticatedUser();

        Expense exp = expenseRepo.findByExpIdAndUser(expId,user).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found"));

        expenseRepo.delete(exp);

        return "Expense deleted";
    }
}
