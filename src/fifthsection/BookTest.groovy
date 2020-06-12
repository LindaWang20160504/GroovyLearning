package fifthsection

import groovy.test.GroovyTestCase
import thirteenthsection.Book

class BookTest  extends  GroovyTestCase{
    /**
     * Test that the expected String is returned from toString
     */
    def void testToString(){
        def bk1 = new Book(catalogNumber: "111",title: 'Groovy',author: 'Ken')
        def expected = 'Book :111:Groovy by:Ken'
        assertToString(bk1,expected)
    }
}
