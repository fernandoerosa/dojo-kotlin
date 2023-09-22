package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import Sale

@SpringBootApplication class DojoKotlinApplication

fun main(args: Array<String>) {
    println("Bora Cleber!")

    var sale = Sale()

    val map = sale.smallNumber(100.0, 90.0)   

    println(map)
    println(sale.smallNumber(200.0, 40.37))
    

    val saleValue = 40.37;
        val paidValue = 200.0;

        val map:Map<Double,Int> = sale.smallNumber(paidValue, saleValue)

        var result = 0.0;
        for((nota, qtd) in map){
            result += nota * qtd
        }

    println(result)
}



