package fourteenthsection

//抽象方法
abstract class AbstractAccount {
    def number
    def balance

    String toString() {
        return "${number}; ${balance}"
    }

    def abstract isOverdrawn()
}

class BAccount extends AbstractAccount {
    def overdrafLimit

    String toString() {
        return "Current Account :" + super.toString() + "; ${overdrafLimit}"
    }

    @Override
    def isOverdrawn() {
        return balance < -overdrafLimit
    }
}

class CAccount extends AbstractAccount {
    def interestRate

    String toString() {
        return "Deposit Account :" + super.toString() + "; ${interestRate}"
    }

    @Override
    def isOverdrawn() {
        return balance < 0
    }

    public static void main(String[] args) {
        def bk = new Bank(name: "Barclay")
        def ca1 = new BAccount(number: 'AAA111', balance: 2000, overdrafLimit: 400)
        def ca2 = new BAccount(number: 'BBB222', balance: 2000, overdrafLimit: 400)
        def ca3 = new CAccount(number: 'CC222', balance: 2000, interestRate: 4)
        bk.openAccount(ca1)
        bk.openAccount(ca2)
        bk.openAccount(ca3)
        bk.disPlayBank(bk)
    }
}

