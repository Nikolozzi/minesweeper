import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val number = scanner.nextInt()
    if(number in -14..12 || number in 15..16 || number in 19..Int.MAX_VALUE)
        println("True")
    else
        println("False")

    // write your code here
}