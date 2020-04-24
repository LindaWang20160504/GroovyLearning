// 03 图书馆应用程序-- 重构的版本

package eleventhsection

def addBook(library,bookTitle){
    library[bookTitle]=[]
}

def removeBook(library,bookTitle){
    library.remove(bookTitle)
}

def lendBook(library,bookTitle,borrowerName){
    library[bookTitle]<<borrowerName
}

def returnBook(library,bookTile,borrowerName){
    println(bookTile)
    println(borrowerName)
    library[bookTile].remove(borrowerName)
}

def displayLoanStock(library){
    println("Library stock :${library}\n")
}

def readBookTile(){
    println("\t Enter book title")
    Scanner scanner = new  Scanner(System.in)
    def bookTile = scanner.nextLine()
    println(bookTile)
    return bookTile
}
def readBorrowerName(){
    println("\t Enter borrower name")
    Scanner scanner =  new Scanner(System.in)
    def borrowerName = scanner.nextLine()
    println(borrowerName)
    return borrowerName
}


def readNumberBorrowedBooks(library,borrowerName){
    def borrowerNames = library.values().asList()
    borrowerNames = borrowerNames.flatten()
    return borrowerNames.count(borrowerName)

}

def readNumberBorrowers(library,bookTile){
    return library[bookTile].size()
}
def readMenuSelection(){
    println()
    println("0:Quit")
    println("1:Add new book")
    println("library03:Remove book")
    println("3:Lend a book")
    println("4:Return book")
    println("5:Display loan stock")
    println("6:Display number of books on loan to a borrower")
    println("7:Display number of borrowers of a book")
    println("\t Enter choice:")
    Scanner scanner =  new Scanner(System.in)
    return  scanner.nextLine()
}
static void main(String[] args) {
    def library = ['Groovy':['Ken','John'],'OOD':['Ken'],'Java':['John','Sally'],'UML':['Sally'],'Basic':[]]
    def doAddBook = {addBook(library, readBookTile())}
    def doRemoveBook = {removeBook(library,readBookTile())}
    def doLenBook= {lendBook(library,readBookTile(),readBorrowerName())}
    def doReturnBook = {returnBook(library,readBookTile(),readBorrowerName())}
    def doDisplayLoanStock = {displayLoanStock(library)}
    def doDisplayNumberBooksOnLoanToBorrower = {
        def count = readNumberBorrowedBooks(library,readBorrowerName())
        println("\n Number of books borrowed: ${count}\n")
    }
    def doDisplayNumberBorrowersOfBook = {
        def count = readNumberBorrowers(library,readBookTile())
        println("\n Number of borrowers: ${count}\n")
    }
    def menu = ['1':doAddBook,'library03':doRemoveBook,'3':doLenBook,'4':doReturnBook,'5':doDisplayLoanStock,
            '6':doDisplayNumberBooksOnLoanToBorrower,'7':doDisplayNumberBorrowersOfBook
    ]

    def choice = readMenuSelection()
    while (choice != '0'){
        menu[choice].call()
        choice = readMenuSelection()
    }
    println("\n System closing \n")
}