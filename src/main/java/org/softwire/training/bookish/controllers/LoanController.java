package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.BookCopy;
import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.models.page.LoansPageModel;
import org.softwire.training.bookish.services.CopiesService;
import org.softwire.training.bookish.services.LoanService;
import org.softwire.training.bookish.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final MemberService memberService;
    private final CopiesService copiesService;

    @Autowired
    public LoanController(LoanService loanService, MemberService memberService, CopiesService copiesService) {
        this.loanService = loanService;
        this.memberService = memberService;
        this.copiesService = copiesService;
    }

    @RequestMapping("")
    ModelAndView loans() {

        List<Loan> allLoans = loanService.getAllLoans();
        List<Member> allMembers = memberService.getAllMembers();
        List<BookCopy> availableBookCopies = copiesService.getAvailableBookCopies();

        LoansPageModel loansPageModel = new LoansPageModel();
        loansPageModel.setLoans(allLoans);
        loansPageModel.setMembers(allMembers);
        loansPageModel.setBookCopies(availableBookCopies);

        return new ModelAndView("loans", "model", loansPageModel);
    }

    @RequestMapping("/add-loan")
//    RedirectView addLoan(@ModelAttribute Loan loan) {
    RedirectView addLoan(@RequestParam int member_id, @RequestParam int bookCopy_id) {

        loanService.addLoan(member_id, bookCopy_id);

        return new RedirectView("/members");
    }

    @RequestMapping("/edit-loan")
    RedirectView editLoan(@RequestParam int loanId, int status) {

        loanService.updateLoan(loanId, status);

        return new RedirectView("/loans");
    }
}
