import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val firstChar = scanner.next().first()
    val secondChar = scanner.next().first()
    val thirdChar = scanner.next().first()
    val fourthChar = scanner.next().first()

    println("${firstChar.isDigit()}\\${secondChar.isDigit()}" +
            "\\${thirdChar.isDigit()}\\${fourthChar.isDigit()}")
}