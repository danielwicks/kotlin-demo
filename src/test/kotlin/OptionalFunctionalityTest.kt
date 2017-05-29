import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.FreeSpec

class OptionalFunctionalityTest : FreeSpec() {
    init {

        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        "Map entry that exists should not be null" {
            map.get("a") shouldNotBe null
        }

        "Map entry that does not exist should be null" {

            map.get("1") shouldBe null
        }

        "Performing method on null response also returns null with Elvis operator" {
            val get = map.get("1")
            val toFloat = get?.toFloat()

            toFloat shouldBe null
        }

        "Equivalent to getOrElse returns default value" {

            val get = map.get("1")

            get ?: -1 shouldBe -1
        }

        "Equivalent to getOrElse returns value when present" {

            val get = map.get("a")

            get ?: -1 shouldBe 1
        }


    }
}
