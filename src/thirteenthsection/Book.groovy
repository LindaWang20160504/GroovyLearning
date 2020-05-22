package thirteenthsection

// library 2
class Book {
    def catalogNumber
    def title
    def author
    def borrower = null

    def attachBorrower(borrower) {
        this.borrower = borrower
    }

    def detachBorrower() {
        borrower = null
    }

    String toString() { //redefinition
        return "Book :${catalogNumber}:${title}:${author}"
    }
}

class Borrower {
    def membershipNumber
    def name
    def borrowedBooks = [:]

    def attachBook(bk) {
        borrowedBooks[bk.catalogNumber] = bk
        bk.attachBorrower(this)
    }

    def detachBook(bk) {
        borrowedBooks.remove(bk.catalogNumber)
        bk.detachBorrower()
    }

    String toString() {
        return "Borrower:${membershipNumber};${name}"
    }
}

class Library {
    def name
    def loanStock = [:]
    def borrowers = [:]

    def addBook(bk) {
        loanStock[bk.catalogNumber] = bk

    }

    def displayStock() {
        println("Library :${name}")
        println("---------------")
        loanStock.each { catalogNumber, book ->
            println("${book}")
        }
    }

    def displayBooksAvailableForLoan() {
        println("\n \nLibrary :${name}:Available for loan")
        println("===================")
        loanStock.each { catalogNumber, book ->
            if (book.borrower == null) {
                println("${book}")
            }
        }
    }

    def displayBookOnLoan() {
        println("\n \n Library:${name}:On loan")
        println("============")
        loanStock.each { catalogNumber, book ->
            if (book.borrower != null) {
                println("${book}")
            }
        }
    }

    def registerBorrower(borrower) {
        borrowers[borrower.membershipNumber] = borrower
    }

    def displayBorrowers() {
        println("\n \n Library :${name}: Borrower details")
        println("==============")
        borrowers.each { membershipNumber, borrower ->
            println(borrower)
            borrower.borrowedBooks.each { catalogNumber, book ->
                println("${book}")
            }

        }
    }

    def lendBook(catalogNumber, membershipNumber) {
        def loanStockEntry = loanStock.find { entry -> entry.key == catalogNumber }
        def borrowersEntry = borrowers.find { entry -> entry.key == membershipNumber }
        borrowersEntry.value.attachBook(loanStockEntry.value)
    }

    def returnBook(catalogNumber) {
        def loanStockEntry = loanStock.find { entry -> entry.key == catalogNumber }
        def bor = loanStockEntry.value.borrower
        bor.detachBook(loanStockEntry.value)
    }

    public static void main(String[] args) {
        def lib = new Library(name: "Dunning")
        def bk1 = new Book(catalogNumber: "111", title: 'Groovy', author: 'Ken')
        def bk2 = new Book(catalogNumber: "222", title: 'Groovy', author: 'Ken')
        def bk3 = new Book(catalogNumber: "2333", title: 'Groovy', author: 'John')
        lib.addBook(bk1)
        lib.addBook(bk2)
        lib.addBook(bk3)
        lib.displayStock()
        def bo1 = new Borrower(membershipNumber: '1234', name: "jessie")
        def bo2 = new Borrower(membershipNumber: '5678', name: "Sally")
        lib.registerBorrower(bo1)
        lib.registerBorrower(bo2)
        //see borrowers
        lib.displayBorrowers()
        //Finally , make some transactions
        lib.displayBooksAvailableForLoan()
        lib.lendBook("111", "1234")
        lib.displayBooksAvailableForLoan()
        lib.displayBookOnLoan()
        lib.displayBorrowers()
        lib.returnBook('111')
        lib.displayBooksAvailableForLoan()
        lib.displayBookOnLoan()
        lib.displayBorrowers()
    }
}
