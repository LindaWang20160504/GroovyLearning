package fifthsection

import groovy.test.GroovyTestCase
import thirteenthsection.Book
import thirteenthsection.Library

class LibraryTest extends GroovyTestCase {
    /**
     * Set up the fixture
     */
    // ----properties
    def lib
    def bk1
    def bk2
    def bk3

    void setUp() {
        lib = new Library(name: "Dunning")
        bk1 = new Book(catalogNumber: "111", title: 'Groovy', author: 'Ken')
        bk2 = new Book(catalogNumber: '222', title: 'ODD', author: 'Ken')
        bk3 = new Book(catalogNumber: '222', title: 'UML', author: 'John')
    }
    /**
     * Test that addition of a book to an empty library results in one more book in the library
     */
    void testAddBook_l() {
        def pre = lib.loanStock.size()
        lib.addBook(bk1)
        def post = lib.loanStock.size()
        print("post-->" + post)
        assertTrue('one less book than expected ', post == pre + 1)
    }

    void testAddBook_2() {
        lib.addBook(bk1)
        lib.addBook(bk2)
        def expected = 2
        def actual = lib.loanStock.size()
        assertTrue("unexpected number of books", expected == actual)
    }

    void testAddBook_3() {
        lib.addBook(bk1)
        lib.addBook(bk2)
        def pre = lib.loanStock.size()
        println("previous count is：" + pre)
        lib.addBook(bk3)
        def post = lib.loanStock.size()
        print("current count is：" + post)
        assertTrue("one more book than expected", pre == post)
    }

    void testAddBook_4() {
        lib.addBook(bk2)
        lib.addBook(bk3)
        def expected = 'Book :111:ODD by:Ken'
        def actual = lib.loanStock['222']
        assertToString(actual,expected)
    }
}
