package com.loans.repo;

import com.loans.Domain.Loan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by sender on 14.02.2017.
 */
@Repository
@Transactional
public class ILoanImpl implements ILoan {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Loan getLoanById(int id) {
        return entityManager.find(Loan.class, id);
    }

    @Override
    public Loan editLoan(Loan loan) {
        entityManager.merge(loan);
        return loan;
    }

    @Override
    public Loan addLoan(Loan loan) {
        entityManager.persist(loan);
        return loan;
    }

    @Override
    public void deleteLoan(Loan loan) {
        entityManager.remove(loan);

    }


}