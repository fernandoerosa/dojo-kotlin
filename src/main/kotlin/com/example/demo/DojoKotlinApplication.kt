package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication as run

@SpringBootApplication
class DojoKotlinApplication

fun main(args: Array<String>) {
    val totalValue = 98.94 // Total amount to be paid
    val paidValue = 100.0 // Actual amount paid

    calculateChange(totalValue, paidValue)
}

fun calculateChange(totalValue: Double, paidValue: Double) {
    val change = paidValue - totalValue

    if (change < 0) {
        println("The paid amount is insufficient to cover the total due.")
        return
    }

    val billsAndCoins = arrayOf(100.0, 50.0, 10.0, 5.0, 1.0, 0.5, 0.1, 0.05, 0.01)
    val billAndCoinNames = arrayOf("100-dollar bills", "50-dollar bills", "10-dollar bills", "5-dollar bills", "1-dollar bills", "50-cent coins", "10-cent coins", "5-cent coins", "1-cent coins")
    var remainingChange = change

    println("Change to be provided:")

    for (i in billsAndCoins.indices) {
        val quantity = (remainingChange / billsAndCoins[i]).toInt()
        println(quantity)
        if (quantity > 0) {
            println("$quantity ${billAndCoinNames[i]}")
            remainingChange -= quantity * billsAndCoins[i]
        }
    }
}
