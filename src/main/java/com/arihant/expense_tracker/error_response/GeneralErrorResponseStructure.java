package com.arihant.expense_tracker.error_response;

import java.time.LocalDateTime;

public class GeneralErrorResponseStructure {
    public String message;
    public LocalDateTime dateTime;
    public int status_code;
}
