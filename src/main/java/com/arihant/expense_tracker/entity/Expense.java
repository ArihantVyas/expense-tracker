package com.arihant.expense_tracker.entity;

import com.arihant.expense_tracker.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title name must be provided")
    @Size(max = 60)
    private String title;

    // Will only accept these listed values. Requires validation handling in controller
    @Pattern(regexp = "Food|Travel|Shopping|Entertainment|Work|Rent|Gym|Bills|Subscriptions")
    private String category;

    // It will also only accept the values defined in enum. Also requires validation handling in controller
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @NotNull
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    private LocalDate expenseDate;

    private LocalDateTime entryDateTime;

    @Size(max = 500)
    private String remark;

    /* A no-args constructor is required by the JPA and Hibernate because it doesn't know which fields are to be passed,
     So it initially creates an empty object.
     Along with that it requires getters and setters to populate the empty object
     */
    public Expense() {
    }

    public Expense(String title, String category, TransactionType type, Double amount, LocalDate expenseDate) {
        this.title = title;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

   // Runs only for the first time when entry is done
    @PrePersist
    public void setEntryDateTime() {
        this.entryDateTime = LocalDateTime.now();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}