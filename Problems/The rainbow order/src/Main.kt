import java.util.Scanner

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val rainbow = input.next().toUpperCase()
    println(Rainbow.valueOf(rainbow).ordinal + 1)
}