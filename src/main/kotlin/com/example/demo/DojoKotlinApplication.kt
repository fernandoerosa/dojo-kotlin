package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication class DojoKotlinApplication

fun main(args: Array<String>) {
    val totalValue = 98.94 // Total amount to be paid
    val paidValue = 100.0 // Actual amount paid

    alterantiveCalculateChange(totalValue, paidValue)
    calculateChange(totalValue, paidValue)
}

fun alterantiveCalculateChange(totalValue: Double, paidValue: Double) {

    val change = paidValue - totalValue

    if (change < 0) {
        println("The paid amount is insufficient to cover the total due.")
        return
    }

    val billsAndCoinsMap =
            mapOf<Double, String>(
                    100.0 to "100-real bills",
                    50.0 to "50-real bills",
                    10.0 to "10-real bills",
                    5.0 to "5-real bills",
                    1.0 to "1-real bills",
                    0.5 to "50-cent coins",
                    0.1 to "10-cent coins",
                    0.05 to "5-cent coins",
                    0.01 to "1-cent coins"
            )

    var remainingChange = change

    var changeMap = mutableMapOf<Double, Int>()

    println("Change to be provided:")

    for ((i, value) in billsAndCoinsMap) {
        val quantity = (remainingChange / i).toInt()
        if (quantity > 0) {
            changeMap[i] = quantity
            remainingChange -= quantity * i
        }
    }

    println("Map -> $changeMap")

    for ((k, v) in changeMap) {
        println("$v bills of R$ $k")
    }

    println("----------------")
}

fun calculateChange(totalValue: Double, paidValue: Double) {
    val change = paidValue - totalValue

    if (change < 0) {
        println("The paid amount is insufficient to cover the total due.")
        return
    }

    val billsAndCoins = arrayOf(100.0, 50.0, 10.0, 5.0, 1.0, 0.5, 0.1, 0.05, 0.01)
    val billAndCoinNames = arrayOf("100-real bills", "50-real bills", "10-real bills", "5-real bills", "1-real bills", "50-cent coins", "10-cent coins", "5-cent coins", "1-cent coins")
    var remainingChange = change

    println("Change to be provided:")

    for (i in billsAndCoins.indices) {
        val quantity = (remainingChange / billsAndCoins[i]).toInt()
        if (quantity > 0) {
            println("$quantity ${billAndCoinNames[i]}")
            remainingChange -= quantity * billsAndCoins[i]
        }
    }
}
