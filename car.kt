fun main() {
    drive(
        Manual("Honda ","White ", speed = 50),
        Decide("Rumuola", Manual("Mercedes", "Black", speed = 35))
    )
    drive(
        Automatic(colour ="Brown ", passenger = 10, speed = 70),
        Decide("Rumuokwuta", Automatic("Audi", "White", speed = 65))
    )

}
fun drive(car:Car, rod:Decide){
    when{ (car is Manual)
    -> println("Manual Car, ${car.colour + car.brand}")
        (car is Automatic)
        -> println("Automatic Car, ${car.colour + car.brand}")
        else
        -> println("Unrecognized Vehicle")
    }
    if (car.passenger <= 4) {
        rod.side()
        car.move(car.speed)
    }
    else
        println("Too many People")
}


interface Car {
    val brand:String
    val colour:String
    val passenger:Int
    val speed:Int
    fun move(speed: Int)
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
    override val passenger:Int = 4,
    override val speed: Int
):Car{
    override fun move(speed: Int){
        if (speed> 60)
            println("Speed above limit")
        else
            println("Drive Safely")
    }
}

class Automatic(
    override val brand:String = "Audi ",
    override val colour:String,
    override val passenger:Int = 4,
    override val speed: Int
):Car{
    override fun move(speed: Int) {
        if (speed > 50)
            println("Speed above limit")
        else
            println("Drive Safely")
    }
}