import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val text = scanner.nextLine()
    val index = scanner.nextInt()

    println("Symbol # $index of the string \"$text\" is '${text[index - 1]}'")
}