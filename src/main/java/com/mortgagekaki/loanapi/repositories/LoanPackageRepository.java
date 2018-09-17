package com.mortgagekaki.loanapi.repositories;

import com.mortgagekaki.loanapi.models.LoanPackage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * the loan package repository
 */
@Repository
public interface LoanPackageRepository extends CrudRepository<LoanPackage, String>,
        JpaSpecificationExecutor<LoanPackage> {
}
