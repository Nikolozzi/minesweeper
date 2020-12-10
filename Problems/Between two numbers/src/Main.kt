import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val firstNum = scanner.nextInt()
    val secondNum = scanner.nextInt()
    val thirdNum = scanner.nextInt()

    println(firstNum in secondNum..thirdNum)

    // write your code here
}