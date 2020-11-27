package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.models.page.LoansPageModel;
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

    @Autowired
    public LoanController(LoanService loanService, MemberService memberService) {
        this.loanService = loanService;
        this.memberService = memberService;
    }

    @RequestMapping("")
    ModelAndView loans() {

        List<Loan> allLoans = loanService.getAllLoans();
        List<Member> allMembers = memberService.getAllMembers();

        LoansPageModel loansPageModel = new LoansPageModel();
        loansPageModel.setLoans(allLoans);
        loansPageModel.setMembers(allMembers);

        return new ModelAndView("loans", "model", loansPageModel);
    }

//    @RequestMapping("/add-loan")
//    RedirectView addLoan(@ModelAttribute Loan loan) {
//
//        loanService.addLoan(loan);
//
//        return new RedirectView("/members");
//    }

    @RequestMapping("/edit-loan")
    RedirectView editLoan(@RequestParam int loanId, int status) {

        loanService.updateLoan(loanId, status);

        return new RedirectView("/loans");
    }
}
