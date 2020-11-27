package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService extends DatabaseService {

    public List<Loan> getAllLoans() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT member.name AS \"member\", book.name AS \"title\", loan.loanTime, loan.dueDate, loan.status\n" +
                        "FROM loan\n" +
                        "INNER JOIN bookcopy ON bookcopy.id=loan.copyId\n" +
                        "INNER JOIN book ON bookcopy.bookIsbn=book.isbn\n" +
                        "INNER JOIN member ON  member.id= loan.memberId")
                        .mapToBean(Loan.class)
                        .list()
        );
    }

//    public void addLoan(Loan loan) {
//        jdbi.useHandle(handle ->
//                handle.createUpdate("INSERT INTO member (name) VALUES (:name)")
//                        .bind("name", loan.getLoanTime())
//                        .execute()
//        );
//    }

    public void updateLoan(int loanId, int status) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE loan SET status = :returned WHERE id = :id")
                        .bind("id", loanId)
                        .bind("status", status)
                        .execute()
        );
    }
}
