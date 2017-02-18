package com.loans.repo;

import com.loans.Domain.Loan;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sender on 14.02.2017.
 */

@Repository
@Transactional
public interface ILoan {

    Loan getLoanById(int id);

    Loan editLoan(Loan loan);

    Loan addLoan(Loan loan);

    void deleteLoan(Loan loan);



}