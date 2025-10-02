import kotlin.math.round

val firstName: String = "Joe"
val surName: String = "Soap"
val gender: Char = 'M'
val employeeId = 6143
val grossSalary = 67_543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonusAmount = 1_450.50
val cycleSchemeDeduction = 54.33

fun main (args: Array<String>) {

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun menu() : Int {
    print("""
        Employee Menu for ${getFullName()}
            1. Monthly Salary
            2. Monthly PRSI
            3. Monthly PAYE
            4. Monthly Gross Pay
            5. Monthly Total Deductions
            6. Monthly Net Pay
            7. Full Payslip
            -1. Exit
        Enter Option : """)
    return readln().toInt()
}
fun getPayslip() = """
        __________________________________________________
        |                Monthly Payslip                 |
        |________________________________________________|
        |  Employee Name: ${getFullName()}  Employee ID: ${employeeId} |
        |________________________________________________|
        |    PAYMENT DETAILS       DEDUCTION DETAILS     |
        |________________________________________________|
        |    Salary: ${getMonthlySalary()}        PAYE: ${getMonthlyPAYE()}         |
        |    Bonus: ${getMonthlyBonus()}         PRSI: ${getMonthlyPRSI()}          |
        |                          Cycle to Work: ${cycleSchemeDeduction}  |
        |________________________________________________|
        |   Gross: ${getGrossMonthlyPay()}   Total Deductions: ${getTotalMonthlyDeductions()}   |
        |________________________________________________|
        |                NET PAY: ${getNetMonthlyPay()}               |
        |________________________________________________|"""


fun roundNumber(number: Double) = round(number*100) /100

fun getFullName() = when (gender){
    'm', 'M' -> "Mr $firstName $surName"
    else -> { "Ms $firstName $surName"
    }
}

fun getMonthlySalary() = roundNumber(grossSalary / 12)

fun getMonthlyPAYE() = roundNumber(getMonthlySalary()/100*payePercentage)

fun getMonthlyBonus() = roundNumber(annualBonusAmount/12)

fun getMonthlyPRSI() = roundNumber(getMonthlySalary()/100*prsiPercentage)

fun getGrossMonthlyPay() = roundNumber(getMonthlySalary()+(annualBonusAmount/12))

fun getTotalMonthlyDeductions() = roundNumber(getMonthlyPRSI()+getMonthlyPAYE()+cycleSchemeDeduction)

fun getNetMonthlyPay() = roundNumber(getGrossMonthlyPay()-getTotalMonthlyDeductions())