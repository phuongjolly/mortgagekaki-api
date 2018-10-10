package com.mortgagekaki.loanapi.models;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LoanPackageSpecification implements Specification<LoanPackage> {

    private final String propertyType;
    private final LoanType loanType;
    private final PackageType type;
    private final String lockIn;

    public LoanPackageSpecification(PackageType type,
                                    String propertyType,
                                    LoanType loanType, String lockIn) {
        this.type = type;
        this.propertyType = propertyType;
        this.loanType = loanType;
        this.lockIn = lockIn;
    }

    @Nullable
    @Override
    public Predicate toPredicate(Root<LoanPackage> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (type != null) {
            predicates.add(
                criteriaBuilder.or(
                    criteriaBuilder.equal(
                        root.get("type"), type
                    ),
                    criteriaBuilder.equal(
                        root.get("type"), PackageType.BOTH
                    )
                )
            );
        }

        if (propertyType != null) {
            predicates.add(
                criteriaBuilder.equal(
                    root.get("propertyType"), propertyType
                )
            );
        }

        if (loanType != null) {
            predicates.add(

                criteriaBuilder.or(
                    criteriaBuilder.equal(
                        root.get("loanType"), loanType
                    ),
                    criteriaBuilder.equal(
                        root.get("loanType"), LoanType.BOTH
                    )
                )

            );
        }

        if (lockIn != null) {
            predicates.add(
                criteriaBuilder.equal(
                    root.get("lockIn"), lockIn
                )
            );
        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
