import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var num = scanner.nextInt()
    var totalSum = 0
    while(num != 0){
        totalSum += num % 10
        num /= 10
    }

    println(totalSum)
}