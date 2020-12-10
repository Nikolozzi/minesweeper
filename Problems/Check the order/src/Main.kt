import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var previous = Int.MIN_VALUE
    var sorted = true
    repeat(scanner.nextInt()) {
        val num = scanner.nextInt()
        if (num <= previous) {
            sorted = false
        }

        previous = num
    }

    println(if (sorted) "YES" else "NO")
}