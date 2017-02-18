package com.loans.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loans.Domain.Loan;
import com.loans.repo.ILoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sender on 14.02.2017.
 */
@RestController
@RequestMapping(value = "/loan")
public class LoanController {

    @Autowired
    ILoan loanRepository;

    @RequestMapping(value = "/byId/{loanId}",method = RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public Loan getItemById(@PathVariable("loanId") int id) {
        Loan loanById = loanRepository.getLoanById(id);
        System.out.println(loanById);
        return loanById;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public Loan addLoan(@RequestBody Loan loan) {
        System.out.println(loan);
        loanRepository.addLoan(loan);
        return loan;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public Loan updateLoan (@RequestBody Loan loan) {
        System.out.println(loan);
        loanRepository.editLoan(loan);
        return loan;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE},headers = "Accept=application/json")
    public Loan deleteLoan (@PathVariable("id")int id) {
        System.out.println(id);
        Loan todelate = loanRepository.getLoanById(id);
        System.out.println(todelate);
        loanRepository.deleteLoan(todelate);
        return todelate;
    }


    @RequestMapping(value = "/xml/byId/{loanId}",method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public Loan getItemByIdXML(@PathVariable("loanId") int id) {
        Loan loanById = loanRepository.getLoanById(id);
        System.out.println(loanById);
        return loanById;
    }

    @RequestMapping(value = "/xml/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE,produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public Loan addLoanXML(@RequestBody Loan loan) throws JsonProcessingException {
        System.out.println(loan);
        loanRepository.addLoan(loan);
        return loan;
    }

    @RequestMapping(value = "/xml/update", method = RequestMethod.PUT,produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public Loan updateLoanXML (@RequestBody Loan loan) {
        System.out.println(loan);
        loanRepository.editLoan(loan);
        return loan;
    }

    @RequestMapping(value = "/xml/delete/{id}", method = RequestMethod.DELETE,produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public Loan deleteLoanXML (@PathVariable("id")int id) {
        System.out.println(id);
        Loan todelate = loanRepository.getLoanById(id);
        loanRepository.deleteLoan(todelate);
        return todelate;
    }







}
