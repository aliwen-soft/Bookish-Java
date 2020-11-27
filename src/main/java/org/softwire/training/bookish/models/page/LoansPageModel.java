package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;

import java.util.List;

public class LoansPageModel {
    private List<Loan> loans;
    private List<Member> members;

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
