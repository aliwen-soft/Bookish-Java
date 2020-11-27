const BOOKS = document.querySelectorAll("#booksTable tr")
const NAMEINPUT = document.querySelector('#nameInput')
const DESCRIPTONINPUT = document.querySelector('#descriptionInput')

document.querySelector("#editForm").onchange = function(){
    for (let i = 0; i < BOOKS.length; i++) {
        const BOOK = BOOKS[i];
        if (BOOK.cells[0].innerText==document.querySelector("#isbn").value) {
            NAMEINPUT.setAttribute("value", BOOK.cells[1].innerText)
            DESCRIPTONINPUT.setAttribute("value", BOOK.cells[2].innerText)
            break
        }
    }
}