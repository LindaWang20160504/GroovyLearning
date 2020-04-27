package fourteenthsection

class CurrentAccount {
    def number
    def  balance
    def  overdrafLimit

    String toString() {
        return "Current Account ：${number}; balance : ${balance}; overdraft :${overdrafLimit}"
    }
    public static void main(String[] args) {
        def accounts = [new BankAccount(number: 'AAA111',balance: 1000, overdrafLimit: 400), new BankAccount(number: 'BBB222', balance: 2500,overdrafLimit: 800)]
        accounts.each {acc->
            println(acc)
        }
    }
}
