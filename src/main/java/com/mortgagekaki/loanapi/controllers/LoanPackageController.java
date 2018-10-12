package com.mortgagekaki.loanapi.controllers;

import com.mortgagekaki.loanapi.models.LoanPackage;
import com.mortgagekaki.loanapi.models.LoanType;
import com.mortgagekaki.loanapi.models.PackageType;
import com.mortgagekaki.loanapi.services.LoanPackageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
public class LoanPackageController {

    /**
     * the service
     */
    private final LoanPackageService service;

    /**
     * create an instance of loan package controller
     * @param service
     */
    public LoanPackageController(LoanPackageService service) {
        this.service = service;
    }

    /**
     * Query all loan package using type/property type/loan-type and lockin
     * @param type the package type
     * @param propertyType the property type
     * @param loanType the loan type
     * @param lockIn whether lock-in or not
     * @return
     */
    @GetMapping
    public List<LoanPackage> query(
            @RequestParam(name = "type", required = false) PackageType type,
            @RequestParam(name = "propertyType", required = false) String propertyType,
            @RequestParam(name = "loanType", required = false) LoanType loanType,
            @RequestParam(name = "lockIn", required = false) String lockIn
            ) {
        return service.query(type, propertyType, loanType, lockIn);
    }
}
