INSERT INTO Book
VALUES 
	(1111111111111, "My Book", "A very interesting book"),
    (2222222222222, "Alice's Book", "Another very interesting book"),
    (3333333333333, "Wendi's Book", "Yet another very interesting book"),
    (4444444444444, "Head First Design Patterns", "A very weird book"),
    (5555555555555, "Head First Design Patterns 2", "A book about coding");
    
INSERT INTO Author (name)
VALUES
	("Joe"),
    ("Alice"),
    ("Wendi"),
    ("Eric Freeman");
    
INSERT INTO BookAuthor
VALUES
	(0, 1111111111111),
    (1, 2222222222222),
    (3, 3333333333333),
    (4, 4444444444444),
    (4, 5555555555555);
    
INSERT INTO Genre (name, ageGroup)
VALUES
	("Educational", "0-99+"),
    ("Kids", "0-10"),
    ("Adult", "10+");
    
INSERT INTO BookGenre
VALUES
	(0, 4444444444444),
    (0, 5555555555555),
    (1, 1111111111111),
    (2, 2222222222222),
    (2, 3333333333333);
    
INSERT INTO Member (name)
VALUES
	("Tom"),
    ("Emily"),
    ("Kirsty");
    
INSERT INTO BookCopy (bookIsbn)
VALUES
	(1111111111111),
    (1111111111111),
    (2222222222222);
    
INSERT INTO Loan (memberId, copyId, loanTime, dueDate, status)
VALUES
	(0, 1, "2020-11-17 12:53:46", "2020-12-01", true);