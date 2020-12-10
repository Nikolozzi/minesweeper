import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val cups = scanner.nextInt()
    val isWeekend = scanner.nextBoolean()

    if(!isWeekend)
        println(cups in 10..20)
    else
        println(cups in 15..25)
}