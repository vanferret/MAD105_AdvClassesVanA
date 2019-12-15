import java.text.DecimalFormat
import kotlin.math.min

class Employee constructor(var name: String? = "Pat Jones",
                           var position: String? = "",
                           var salary: Boolean? = false,
                           var payRate: Double? = 0.00,
                           var shift: Int? = 1,
                           var startdate: String? = ""){
    init {
        //leave it empty for now
    }

    fun getAllWeeklyPretty(){
        var strOut = name + "\n" + position + " Is Salary: " + salary.toString() + " shift: " + shift.toString() + "\n"
        strOut += "Rate of pay is: " + payRate.toString() + " per hour"

        println(strOut)
    }

    fun getMyName(): String?{
        return name
    }

    fun getMyPosition(): String?{
        return position
    }

    fun getMyShift(): Int?{
        return shift
    }

    fun setMyName(nameIn: String?){
        name = nameIn
    }

    fun setMyPosition(positionIn: String?){
        position = positionIn
    }
    fun setMyShift(shiftIn: Int?){
       shift = shiftIn
    }
    fun calculate(hoursIn: Double) {
        val formatter = DecimalFormat("\u00A4###,###,###.00")
        var payOut: Double = 0.00
        var payOutStr: String = ""
        val payBase = payRate
        var upPay = 0.00
        var otPay = 0.00
        val regularHours: Double = if (hoursIn > 40.0) {40.0} else {hoursIn}
        val otHours = if (hoursIn > 40.0) {hoursIn - 40.0} else {0.00}

        // Pay on second shift is 5% higher
        if (shift == 1){
            if (payBase != null) {
                upPay = payBase
            }
        }
        // Pay on second shift is 5% higher
        if (shift == 2){
            if (payBase != null) {
                upPay = payBase * 1.05
            }
        }
        // Pay on third shift is 10% higher
        if (shift == 3){
            if (payBase != null) {
                upPay = payBase * 1.1
            }
        }
        // Overtime for all employees NOT salary is >40 and is 1.5x normal pay
        if(!salary!!){
            otPay = otHours * payBase!!
        }
        upPay *= regularHours
        payOut = upPay + otPay
        payOutStr = formatter.format(payOut)
        println("$name earned $payOutStr this week \n")
    }
}

enum class PositionTitle{
    Administration, Production, Sales, Maintenance, Technical, Secretarial
}