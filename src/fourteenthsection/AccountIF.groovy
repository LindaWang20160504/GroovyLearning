package fourteenthsection

//接口类的实例
interface AccountIF {
    def abstract isOverdrawn()
}

abstract class AccountAN implements AccountIF {
    def number
    def balance

    String toString() {
        return "${number}; ${balance}"
    }

    def isOverdrawn() {
        return balance < 0
    }
}

class AccountAA extends AccountAN {
    def overdraftLimit

    String toString() {
        return "AccountAA" + super.toString() + "${overdraftLimit}"
    }

    def isOverdrawn() {
        return balance < -overdraftLimit
    }
}

class AccountAM extends AccountAN {
    def interestRate

    String toString() {
        return "AccountAM" + super.toString() + "${interestRate}"
    }

    static void main(String[] args) {
        def bk = new Bank(name: "Barclay")
        def ca1 = new BAccount(number: 'AAA111', balance: 500, overdrafLimit: 400)
        def ca2 = new BAccount(number: 'BBB222', balance: 6, overdrafLimit: 400)
        def ca3 = new CAccount(number: 'CC222', balance: 8, interestRate: 4)
        bk.openAccount(ca1)
        bk.openAccount(ca2)
        bk.openAccount(ca3)
        bk.disPlayBank(bk)
    }
}