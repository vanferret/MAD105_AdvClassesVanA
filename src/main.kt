import javax.swing.text.Position

fun main() {

    // Ideally, I would have a container class for my employees, but for now I will create all the separate
    // objects here
    val employee1 = Employee("Van Anderson", PositionTitle.Technical.name,true, 25.00, 1,"11/15/2004")
    val employee2 = Employee("Aaron Kinney", PositionTitle.Maintenance.name, false,28.00,2,"5/15/2003")
    val employee3 = Employee("Meghan Cunningham",PositionTitle.Sales.name,false,33.00,3,"2/2/2006")

    employee1.getAllWeeklyPretty()
    employee1.calculate(45.0)
    employee2.getAllWeeklyPretty()
    employee2.calculate(50.0)
    employee3.getAllWeeklyPretty()
    employee3.calculate(35.0)
}