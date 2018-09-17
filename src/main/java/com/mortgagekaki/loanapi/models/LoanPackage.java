package com.mortgagekaki.loanapi.models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOAN_PACKAGES")
@SecondaryTable(
    name="LOAN_PACKAGES_PROPERTY",
    pkJoinColumns = @PrimaryKeyJoinColumn(name="PACKAGE_ID", referencedColumnName="PACKAGE_ID")
)
public class LoanPackage {

    @Id
    @Column(name = "PACKAGE_ID")
    private String id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private PackageType type;

    @Column(name = "PACKAGE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @Column(name = "LOAN_TYPE")
    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Column(name = "ADDITIONAL_INFO")
    private String additionInfo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "Y1_REF_RATE_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private BaseRate year1Rate;

    @Column(name = "Y1_ABOSULATE_RATE")
    private BigDecimal year1AbsoluteRate;

    @ManyToOne()
    @JoinColumn(name = "Y2_REF_RATE_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private BaseRate year2Rate;

    @Column(name = "Y2_ABOSULATE_RATE")
    private BigDecimal year2AbsoluteRate;

    @ManyToOne(optional = true)
    @JoinColumn(name = "Y3_REF_RATE_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private BaseRate year3Rate;

    @Column(name = "Y3_ABOSULATE_RATE")
    private BigDecimal year3AbsoluteRate;

    @Column(name = "PROPERTY_TYPE", table = "LOAN_PACKAGES_PROPERTY")
    private String propertyType;

    @Column(name = "LOCK_IN")
    private BigDecimal lockIn;

    @Column(name = "CANCELLATION_FEE")
    private BigDecimal cancellationFee;

    public String getId() {
        return id;
    }

    public Bank getBank() {
        return bank;
    }

    public PackageType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public List<Rate> getRates() {
        List<Rate> result = new ArrayList<>();
        result.add(new Rate(year1Rate, year1AbsoluteRate));
        result.add(new Rate(year2Rate, year2AbsoluteRate));
        result.add(new Rate(year3Rate, year3AbsoluteRate));

        return result;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public BigDecimal getLockIn() {
        return lockIn;
    }

    public BigDecimal getCancellationFee() {
        return cancellationFee;
    }
}
