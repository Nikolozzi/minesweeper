import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val number = scanner.nextInt()
    println(if (number > 0) "positive" else if (number < 0) "negative" else "zero")
//    when {
//        number > 0 -> println("positive")
//        number < 0 -> println("negative")
//        else -> println("zero")
//    }
}