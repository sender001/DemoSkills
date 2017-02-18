package com.loans.Domain;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * Created by sender on 13.02.2017.
 */

@Entity
@Table(name = "LOAN")
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Id")
    int id;


    @Column(name = "Amount")
    double loanAmount;


    @Column(name = "Month_Terms")
    double loanTermsMonths;

    public Loan(){};

    public Loan(int loanAmount, int loanTermsMonths) {
        this.loanAmount=loanAmount;
        this.loanTermsMonths=loanTermsMonths;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanTermsMonths() {
        return loanTermsMonths;
    }

    public void setLoanTermsMonths(int loanTermsMonths) {
        this.loanTermsMonths = loanTermsMonths;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanAmount=" + loanAmount +
                ", loanTermsMonths=" + loanTermsMonths +
                '}';
    }
}
