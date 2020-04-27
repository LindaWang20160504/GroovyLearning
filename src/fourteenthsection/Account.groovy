package fourteenthsection

class Account {
    def number
    def balance

    String toString() {
        return "${number}；${balance}"
    }
}

class BankAccount extends Account {
    def overdrafLimit

    String toString() {
        return "Current Account :" + super.toString() + "; ${overdrafLimit}"
    }
}

class DepositAccount extends Account {
    def interestRate

    String toString() {
        return "Deposit Account :" + super.toString() + "; ${interestRate}"
    }
}

class Bank {
    def name
    def accounts = [:]

    def openAccount(account) {
        accounts[account['number']] = account
    }

    def disPlayBank(bk) {
        println("Bank :${bk.name}")
        println("---------------------")
        bk.accounts.each { number, account ->
            println("${account}")

        }
    }

    public static void main(String[] args) {
        def bk = new Bank(name: "Barcly")
        def ca1 = new BankAccount(number: "AAA111", balance: 20000, overdrafLimit: 4000)
        def ca2 = new BankAccount(number: "BBB222", balance: 3000, overdrafLimit: 800)
        def da1 = new DepositAccount(number: 'CCC333', balance: 4000, interestRate: 4)
        bk.openAccount(ca1)
        bk.openAccount(ca2)
        bk.openAccount(da1)
        bk.disPlayBank(bk)
    }
}

