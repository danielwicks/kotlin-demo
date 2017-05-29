package operatoroverload

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


internal class WalletTest : StringSpec() {

    init {

        val wallet = Wallet(0)

        "Secondary Constructor input sets balance" {
            wallet.getBlanace() shouldBe 0
        }

        "Topping up should add value to the balance" {

            // when
            wallet.topUp(100)

            // then
            wallet.getBlanace() shouldBe 100
        }

        "Adding two Wallet's results in the correct value" {

            // given
            wallet.topUp(100)
            val secondWallet = Wallet(100)

            // when
            val resultWallet = wallet + secondWallet

            // then
            resultWallet.getBlanace() shouldBe 200
        }
    }

}
