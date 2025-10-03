package ie.setu

import roundNumber

class Employee (var firstName: String, var surName: String, var gender: Char, var employeeID: Int,
                var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
                var annualBonus: Double, var cycleToWorkSchemeDeduction: Double) {


    fun getPayslip() = """
        __________________________________________________
        |                Monthly Payslip                 |
        |________________________________________________|
        |  Employee Name: ${getFullName()}  Employee ID: ${employeeID} |
        |________________________________________________|
        |    PAYMENT DETAILS       DEDUCTION DETAILS     |
        |________________________________________________|
        |    Salary: ${getMonthlySalary()}        PAYE: ${getMonthlyPAYE()}         |
        |    Bonus: ${getMonthlyBonus()}          PRSI: ${getMonthlyPRSI()}          |
        |                          Cycle to Work: ${cycleToWorkSchemeDeduction}  |
        |________________________________________________|
        |   Gross: ${getGrossMonthlyPay()}   Total Deductions: ${getTotalMonthlyDeductions()}   |
        |________________________________________________|
        |                NET PAY: ${getNetMonthlyPay()}                 |
        |________________________________________________|"""

    fun getFullName() = when (gender){
        'm', 'M' -> "Mr ${firstName} ${surName}"
        'f', 'F' -> "Ms ${firstName} ${surName}"
        else -> "${firstName} ${surName}"
    }

    fun getMonthlySalary() = roundNumber(grossSalary / 12)

    fun getMonthlyPAYE() = roundNumber(getMonthlySalary()/100*payePercentage)

    fun getMonthlyBonus() = roundNumber(annualBonus/12)

    fun getMonthlyPRSI() = roundNumber(getMonthlySalary()/100*prsiPercentage)

    fun getGrossMonthlyPay() = roundNumber(getMonthlySalary()+(annualBonus/12))

    fun getTotalMonthlyDeductions() = roundNumber(getMonthlyPRSI()+getMonthlyPAYE()+cycleToWorkSchemeDeduction)

    fun getNetMonthlyPay() = roundNumber(getGrossMonthlyPay()-getTotalMonthlyDeductions())

    override fun toString(): String {
        return "Employee(firstName='$firstName', surName='$surName', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkSchemeDeduction=$cycleToWorkSchemeDeduction)"
    }


}

