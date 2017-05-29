package extensionmethods

/**
 * Define an extension method to return the string capitalised, in reverse.
 * This can be done as a multi-line function, but Kotlin has
 * support for single expression methods using = expr()
 *
 * When defined here, we need to import it in the packages it's used.
 */
fun String.capsReverse(): String = this.reversed().toUpperCase()
