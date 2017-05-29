package data

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import main.kotlin.Person

internal class PatternMatchingPersonTest : StringSpec() {

    init {
        val person = Person("Bill", 10)
        val farmer = Farmer("Jones", "Emmerdale")

        "When construct has else functionality" {

            calculateNameFromType("") shouldBe "unknown"
        }

        "When construct can identify Person object" {

            calculateNameFromType(person) shouldBe "Bill"
        }

        "When construct can identify Farmer object" {

            calculateNameFromType(farmer) shouldBe "Emmerdale"
        }



        "When stacked-if construct can identify string Fred" {

            calculateNumberFromName("Fred") shouldBe 2
        }

        "When stacked-if construct can identify string Bill and Ted" {

            calculateNumberFromName("Bill") shouldBe 1
            calculateNumberFromName("Ted") shouldBe 1
        }

        "When stacked-if construct can't identify string John (returns else)" {

            calculateNumberFromName("John") shouldBe 0
        }

        "When construct can detect range" {

            isInRange1to5(3) shouldBe 0
            isInRange1to5(6) shouldBe 1
            isInRange1to5(11) shouldBe -1
        }
    }

    private fun isInRange1to5(i: Int) : Int {
        return when(i){
            in 1..5 -> 0
            in 6..10 -> 1
//            !in 1..10 -> -1
            else -> -1
        }
    }

    private fun calculateNameFromType(personObject: Any): String {
        return when (personObject) {

            is Person -> personObject.name

            is Farmer -> personObject.farmName

            else -> "unknown"
        }
    }

    private fun calculateNumberFromName(name: String) : Int {

        return when (name) {
            "Bill", "Ted" -> 1
            "Fred" -> 2
            else -> 0
        }
    }
}
