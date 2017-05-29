package main.kotlin

import JavaInteropTest
import extensionmethods.capsReverse

fun main(args: Array<String>) {

    val p = Person("Fred", 21)
    val p2: Person = Person("Bob", 25)

    var listPersons: MutableList<Person> = mutableListOf()

    listPersons.add(p)
    printList(listPersons)

    listPersons.add(p2)
    printList(listPersons)

    val interop = JavaInteropTest()
    interop.stringValue = "expected"
    System.out.println("Test Interop: ${interop.stringValue}")

    printListToString(listPersons)

    println("fred".capsReverse())
}



private fun printList(listPersons: List<Person>) {
    println()
    listPersons.forEach {
        println("Name: ${it.name}")
    }
}

private fun printListToString(listPersons: List<Person>){
    println()
    listPersons.forEach(::println)
}
