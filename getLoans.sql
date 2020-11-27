SELECT member.name AS "Member", book.name AS "Title", loan.loanTime, loan.dueDate, loan.status
FROM loan
INNER JOIN bookcopy ON bookcopy.id=loan.copyId
INNER JOIN book ON bookcopy.bookIsbn=book.isbn
INNER JOIN member ON  member.id= loan.memberId
