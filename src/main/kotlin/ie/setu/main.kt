import kotlin.math.round
import kotlin.math.roundToInt

fun main (args: Array<String>) {
    println("")
    employee()
}

fun employee() {
    println("\n--------------------------------------------------")
    println("|                Monthly Payslip                 |")
    println("|------------------------------------------------|")
    val firstName: String = "Joe"
    val surName: String = "Soap"
    val gender: Char = 'M'
    val employeeId = 6143
    val grossSalary = 67_543.21
    val payePercentage = 38.5
    val prsiPercentage = 5.2
    val annualBonusAmount = 1_450.50
    val cycleSchemeDeduction = 54.33

    val monthlyPay = grossSalary / 12
    val paye = monthlyPay/100*payePercentage
    val monthlyBonus = annualBonusAmount/12
    val prsi = monthlyPay/100*prsiPercentage
    val grossPay = monthlyPay+monthlyBonus
    val totalDeductions = paye+prsi+cycleSchemeDeduction
    val netPay = monthlyPay-totalDeductions

    println("|  Employee Name: " + firstName + " " + surName + "(" + gender + ")" + "  Employee ID: " + employeeId + " |")
    println("|------------------------------------------------|")
    println("|   PAYMENT DETAILS        DEDUCTION DETAILS     |")
    println("|------------------------------------------------|")
    println("|   Salary: " + roundNumber(monthlyPay) + "         PAYE: " + roundNumber(paye) + "         |")
    println("|   Bonus: " + roundNumber(monthlyBonus) + "          PRSI: " + roundNumber(prsi) + "          |")
    println("|                          Cycle To Work: " + cycleSchemeDeduction + "  |")
    println("|------------------------------------------------|")
    println("|   Gross: " + roundNumber(grossPay) + "   Total Deductions: " + roundNumber(totalDeductions) + "   |")
    println("|------------------------------------------------|")
    println("|                NET PAY: " + roundNumber(netPay)+ "                |")
    println("|------------------------------------------------|")
}

fun roundNumber(number: Double) = round(number*100) /100