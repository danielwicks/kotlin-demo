package operatoroverload

class Wallet {

    private var balance: Int = 0

    constructor(balance: Int) {
        this.balance = balance
    }

    fun topUp(topUpValue: Int) : Int {
        balance += topUpValue

        return balance
    }

    fun getBlanace() : Int {
        return balance.toLong().toInt()
    }

    operator fun plus(second: Wallet) : Wallet {

        val total = balance + second.balance

        return Wallet(total)
    }
}
