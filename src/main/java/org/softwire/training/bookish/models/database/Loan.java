package org.softwire.training.bookish.models.database;

import java.beans.ConstructorProperties;
import java.sql.Date;
import java.sql.Timestamp;

public class Loan {
    private String member;
    private String title;
    private Timestamp loanTime;
    private Date dueDate;
    private int status;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Timestamp loanTime) {
        this.loanTime = loanTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
