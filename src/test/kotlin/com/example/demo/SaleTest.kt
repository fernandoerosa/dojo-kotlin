package com.example.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import Sale

@SpringBootTest
class SaleTest{

    @Test
    fun smallNumberTest(){
        var sale = Sale()

        val map:Map<Double,Int> = sale.smallNumber(100.0, 90.0)

        println(map)
        assert(map[10.00] == 1)

    }

    
    @Test
    fun smallNumberSextoTest(){
        var sale = Sale()

        val saleValue = 40.37;
        val paidValue = 200.0;

        val map:Map<Double,Int> = sale.smallNumber(paidValue, saleValue)

        var result = 0.0;
        for((nota, qtd) in map){
            result += nota * qtd
        }

        assert(result == (paidValue - saleValue))        
    }

    @Test
    fun smallNumberFiftyTest(){
        var sale = Sale()

        val map:Map<Double,Int> = sale.smallNumber(200.0, 40.37)

        println(map)
        assert(map[50.00] == 1)
        assert(map[100.00] == 1)
        assert(map[5.00] == 1)
        assert(map[1.00] == 4)
        assert(map[0.50] == 1)
        assert(map[0.10] == 1)
        assert(map[0.01] == 2)
    }

    @Test
    fun smallNumberWrongTest(){
        var sale = Sale()

        val exception = assertThrows<Exception>{
            sale.smallNumber(100.0, 190.0)
        }

        assert(exception.message == "Pague direito.")
    }

}