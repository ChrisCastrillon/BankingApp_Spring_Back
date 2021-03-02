package com.revature.templates;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TransferFormTemplate {
    
    private int fromAccountNumber;
    private int toAccountNumber;
    private double transferAmount;
    

}
