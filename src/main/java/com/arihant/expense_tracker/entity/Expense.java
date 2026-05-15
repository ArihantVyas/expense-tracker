package com.arihant.expense_tracker.entity;

import com.arihant.expense_tracker.enums.TransactionType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Expense {

    // Wrapper classes are used because they can have 'null' value . Primitive types can't.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String title;

    private String category;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Double amount;

    private LocalDate expenseDate;

    private LocalDateTime entryDateTime;

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

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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