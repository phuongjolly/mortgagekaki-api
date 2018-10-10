package com.mortgagekaki.loanapi.services;

import com.mortgagekaki.loanapi.models.LoanPackage;
import com.mortgagekaki.loanapi.models.LoanPackageSpecification;
import com.mortgagekaki.loanapi.models.LoanType;
import com.mortgagekaki.loanapi.models.PackageType;
import com.mortgagekaki.loanapi.repositories.LoanPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanPackageService {

    private final LoanPackageRepository repository;

    /**
     * create an instance of loan package service
     * @param repository
     */
    public LoanPackageService(LoanPackageRepository repository) {
        this.repository = repository;
    }

    /**
     * query the loan package
     * @return list of loan package
     */
    public List<LoanPackage> query(PackageType type, String propertyType, LoanType loanType, String lockIn) {
        LoanPackageSpecification specification = new LoanPackageSpecification(type, propertyType, loanType, lockIn);
        return repository.findAll(specification);
    }
}
