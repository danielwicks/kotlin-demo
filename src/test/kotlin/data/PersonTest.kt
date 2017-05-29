package data

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import main.kotlin.Person

internal class PersonTest : StringSpec() {

    init {
        val p = Person("Fred", 50)

        "Can access name and age through properties" {

            p.name shouldBe "Fred"
            p.age shouldBe 50
        }

        "Can modify variable name in data class" {

            p.name = "Bob"
//            p.age = 10 //compile error

            p.name shouldBe "Bob"
            p.age shouldBe 50
        }

        "it variable is populated with item in foreach" {
            val listOfPeople = listOf(p)

            listOfPeople.forEach {
                it.name shouldBe "Fred"
                it.age shouldBe 50
            }
        }

        "extractor variables are populated from data class" {
            val (name, age) = p

            name shouldBe "Fred"
            age shouldBe 50
        }

        "component methods available on data class" {

            p.component1() shouldBe "Fred"
            p.component2() shouldBe 50
        }

        "String is automatically type cast when matching type is" {

            val string = "test"

            getLength(string) shouldBe string.length
            getLength(p) shouldBe 0
        }
    }

    private fun getLength(o: Any): Int? {
        return if (o is String) { o.length } else { 0 }
    }
}
