package com.mortgagekaki.loanapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank {

    @Id
    @Column(name = "BANK_ID")
    private String id;

    @Column(name = "BANK_NAME")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
