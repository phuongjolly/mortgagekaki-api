package com.mortgagekaki.loanapi.repositories;

import com.mortgagekaki.loanapi.models.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, String> {
}
