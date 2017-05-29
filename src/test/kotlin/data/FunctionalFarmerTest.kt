package data

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

internal class FunctionalFarmerTest : StringSpec() {

    init {

        val farmers = listOf(
                Farmer("Fred", "Emmerdale"),
                Farmer("John", "Emmerdale"),
                Farmer("Bill", "Orange"),
                Farmer("Tim", "Orange"),
                Farmer("Pete", "Mudd")
        )

        "Only two farmers are from Emmerdale farm" {

            farmers.filter { it.farmName == "Emmerdale" }
                    .size shouldBe 2
        }

        "Only one farmer from Emmerdale farm has a name starting with J" {

            farmers.filter { it.farmName == "Emmerdale" && it.name.startsWith("J") }
                    .size shouldBe 1
        }

        "When farmers sorted by first name, Bill is first" {

            farmers.sortedBy { it.name }.first().name shouldBe "Bill"
        }

        "When farmers sorted by farm name, Orange is the last" {

            farmers.sortedByDescending { it.farmName }.first().farmName shouldBe "Orange"
        }
    }
}
