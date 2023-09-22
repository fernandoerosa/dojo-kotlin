class Sale {

    val moneyList: List<Double> = listOf(0.01, 0.05, 0.10, 0.5, 1.00, 5.00, 10.00, 50.00, 100.00).reversed() 

    fun smallNumber(valuePay: Double, valueSale: Double): Map<Double,Int> {
        var changeValue: Double = valuePay - valueSale
        var listOfMoney = mutableMapOf<Double,Int>()

        if(changeValue < 0) {
            throw Exception("Pague direito.")
        }
        for(money: Double in moneyList) {
            var value: Int = (changeValue / money).toInt()
            println(value)
            
            if (value > 0 && changeValue > 0) {
                changeValue -= money * value
                listOfMoney[money] = value
            } 
        }

        return listOfMoney;
    }

}