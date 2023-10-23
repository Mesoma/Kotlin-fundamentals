fun main() {
    drive(
        Manual("honda","white"),
        Decide("Rumuola", Manual("Mercedes", "Black"))
    )
    drive(
        Automatic(colour ="Brown", passenger = 10),
        Decide("Rumuokwuta", Automatic("Audi", "White"))
    )

}
fun drive(car:Car, rod:Decide){
    if (car is Manual) {
        println(car.brand)
        println(car.colour)
        if (car.passenger <= 4)
            car.move()
        else
            println("Too many People")
    } else {
        println(car.brand)
        if (car.passenger <= 4)
            car.move()
        else
            println("Too many People")
    }
    rod.side()
}


interface Car {
    val brand:String
    val colour:String
    val passenger:Int
    fun move()
}

interface Road {
    val name:String
    fun side()
}

class Decide(
    override val name:String,
    val cartype:Car
):Road{
    override fun side(){
        when {
            (cartype is Manual)
            -> println("Manual Cars on the right")

            (cartype is Automatic)
            -> println("Automatic Cars on the left")

            else
            -> println("Not a recognized car")
        }
    }
}

class Manual(
    override val brand:String,
    override val colour:String,
    override val passenger:Int = 4
):Car{
    override fun move(){
        println("Match your clutch, then accelerate")
    }
}

class Automatic(
    override val brand:String = "Audi",
    override val colour:String,
    override val passenger:Int = 4
):Car{
    override fun move(){
        println("Match your accelerate")
    }
}