//08 银行范例
package twelfthsection

class Account {

    def number
    def balance

    def credit(amount) {
        balance += amount
    }

    def debit(amount) {
        if (balance >= amount) {
            balance -= amount
        }
    }

    String toString() { // redefinition
        return "Account :${number} with balace :${balance}"
    }
}

class Bank {

    def openAccount(number, balance) {
        def acc = new Account(number: number, balance: balance)
        accounts[number] = acc
    }

    def creditAccount(number, amount) {
        def acc = this.findAccount(number)
        if (acc != null) {
            acc.credit(amount)
        }
    }

    def debitAccount(number, amount) {
        def acc = this.findAccount(number)
        if (acc != null) {
            acc.debit(amount)
        }
    }

    def getAccountBalance(number) {
        def acc = this.findAccount(number)
        return (acc == null) ? null : acc.balance
    }

    def getTotalAssets() {
        def total = 0
        accounts.each { number, account ->
            total += account.balance
        }
        return total
    }

    def findAccount(number) {
        def acc = accounts.find { entry -> entry.key == number }
        return (acc == null) ? null : acc.value
    }

    def name
    def accounts = [:]

    static void main(String[] args) {
        def bk = new Bank(name: "Community")
        bk.openAccount("ABC123", 1200)
        bk.openAccount("ABC456", 1000)
        bk.openAccount("ghi789", 2000)
        bk.creditAccount('ABC123', 200)
        bk.debitAccount('ABC123', 900)
        bk.debitAccount('ABC123', 700)
        println("Balance for account ABC123 is： ${bk.getAccountBalance('ABC123')}")
        println("Total assets: ${bk.getTotalAssets()}")
    }
}
