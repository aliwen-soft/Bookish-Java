package org.softwire.training.bookish.models.page;

import lombok.Getter;
import lombok.Setter;
import org.softwire.training.bookish.models.database.BookCopy;
import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;

import java.util.List;

@Getter
@Setter
public class LoansPageModel {
    private List<Loan> loans;
    private List<Member> members;
    private List<BookCopy> bookCopies;
}
