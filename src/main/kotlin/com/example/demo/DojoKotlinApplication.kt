package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication as run

@SpringBootApplication
class DojoKotlinApplication

fun main(args: Array<String>) {
    val valorTotal = 98.94 // Valor total a ser pago
    val valorPago = 100.0 // Valor efetivamente pago

    calcularTroco(valorTotal, valorPago)
}

fun calcularTroco(valorTotal: Double, valorPago: Double) {
    val troco = valorPago - valorTotal

    if (troco < 0) {
        println("O valor pago é insuficiente para cobrir o total a ser pago.")
        return
    }

    val cedulasEMoedas = arrayOf(100.0, 50.0, 10.0, 5.0, 1.0, 0.5, 0.1, 0.05, 0.01)
    val nomesCedulasEMoedas = arrayOf("cédulas de R\$100,00", "cédulas de R\$50,00", "cédulas de R\$10,00", "cédulas de R\$5,00", "cédulas de R\$1,00", "moedas de R\$0,50", "moedas de R\$0,10", "moedas de R\$0,05", "moedas de R\$0,01")
    var trocoRestante = troco

    println("Troco a ser fornecido:")

    for (i in cedulasEMoedas.indices) {
        val quantidade = (trocoRestante / cedulasEMoedas[i]).toInt()
        println(quantidade)
        if (quantidade > 0) {
            println("$quantidade ${nomesCedulasEMoedas[i]}")
            trocoRestante -= quantidade * cedulasEMoedas[i]
        }
    }
}
