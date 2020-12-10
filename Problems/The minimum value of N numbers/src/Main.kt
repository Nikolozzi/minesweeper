import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val nums = mutableListOf<Int>()
    repeat(n) {
        nums.add(scanner.nextInt())
    }

    println(nums.minOrNull())
}