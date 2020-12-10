import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val firstChar = scanner.next().first()
    val secondChar = scanner.next().first()
    val thirdChar = scanner.next().first()
    println(thirdChar.dec() == secondChar && secondChar.dec() == firstChar)
}