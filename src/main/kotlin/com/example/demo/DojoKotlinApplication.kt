package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import ChangeHelper

@SpringBootApplication class DojoKotlinApplication

fun main(args: Array<String>) {
    println(args)

    val calculator = ChangeHelper()

    val totalValue: Double = 150.0 // Total amount to be paid
    val paidValue: Double = 200.0 // Actual amount paid

    val response = calculator.calculateChange(totalValue, paidValue)

    println(response)
}

