package com.example.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import ChangeHelper

@SpringBootTest
class ChangeHelperTest {

    val calculator = ChangeHelper()

	@Test
	fun contextLoads() {
	}

    @Test
    fun testChangeSucess() {
        val totalValue: Double = 150.0
        val paidValue: Double = 200.0
        val expectedMap = mapOf(
            50.0 to 1
        )

        val testMap = this.calculator.calculateChange(totalValue, paidValue)

        assert(expectedMap == testMap)
    }

    @Test
    fun testChangeError() {
        val totalValue: Double = 150.0
        val paidValue: Double = 10.0
        val expectedMap = mapOf(
            50.0 to 1
        )

        val testMap = this.calculator.calculateChange(totalValue, paidValue)

        assert(testMap != expectedMap)
    }

    @Test
    fun testChangeException() {
        val totalValue: Double = 150.0
        val paidValue: Double = 10.0
    
        val exception =  assertThrows<Exception>{ 
            this.calculator.calculateChange(totalValue, paidValue)
         }

        assert(exception.message == "The paid amount is insufficient to cover the total due.")
    }
}
