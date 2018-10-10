package com.mortgagekaki.loanapi.controllers;

import com.mortgagekaki.loanapi.models.Bank;
import com.mortgagekaki.loanapi.repositories.BankRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banks")
public class BankController {

    private final BankRepository bankRepository;

    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping
    public Iterable<Bank> getBanks() {
        return bankRepository.findAll();
    }
}
