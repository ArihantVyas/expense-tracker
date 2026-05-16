package com.arihant.expense_tracker.repository;

import com.arihant.expense_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
