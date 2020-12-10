import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val firstChar = scanner.next().first()
    val secondChar = scanner.next().first()
    println(firstChar.equals(secondChar, ignoreCase = true))
}