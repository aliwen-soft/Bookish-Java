package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Loan;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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

    public void addLoan(int memberId, int copyId) {
        Timestamp loanTime = new Timestamp(System.currentTimeMillis());
        java.sql.Date todaysDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Date dueDate = this.addDays(todaysDate, 14);
//        java.sql.Date dueDate = new Date(2020-12-01);
//        String dueDate = "2020-12-01";

        jdbi.useHandle(handle ->
            handle.createUpdate("INSERT INTO loan (memberId, copyId, loanTime, dueDate, status)\n" +
                            "VALUES (:memberId, :copyId, :loanTime, :dueDate, '1');\n")
                            .bind("memberId", memberId)
                            .bind("copyId", copyId)
                            .bind("loanTime", loanTime)
                            .bind("dueDate", dueDate)
                            .execute()
        );
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

    public void updateLoan(int loanId, int status) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE loan SET status = :returned WHERE id = :id")
                        .bind("id", loanId)
                        .bind("status", status)
                        .execute()
        );
    }
}
