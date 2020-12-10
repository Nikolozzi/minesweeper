import java.util.*

fun main(args: Array<String>) {
    val s = "string"
    print("$s.first()")

    val scanner = Scanner(System.`in`)

    val carSpeed = scanner.nextInt()
    scanner.nextLine()
    val roadLimit = scanner.nextLine()
    if (roadLimit == "no limit")
        checkCarSpeed(speed = carSpeed)
    else
        checkCarSpeed(speed = carSpeed, limit = roadLimit.toInt())
}

fun checkCarSpeed(speed: Int, limit: Int = 60) {
    if (speed > limit)
        println("Exceeds the limit by ${speed - limit} kilometers per hour")
    else
        println("Within the limit")
}