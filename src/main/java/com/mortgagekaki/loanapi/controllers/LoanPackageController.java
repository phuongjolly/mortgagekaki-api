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

    private final LoanPackageService service;

    public LoanPackageController(LoanPackageService service) {
        this.service = service;
    }

    @GetMapping
    public List<LoanPackage> query(
            @RequestParam(name = "type", required = false) PackageType type,
            @RequestParam(name = "propertyType", required = false) String propertyType,
            @RequestParam(name = "loanType", required = false) LoanType loanType
            ) {
        return service.query(type, propertyType, loanType);
    }
}
