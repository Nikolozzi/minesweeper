import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val population = scanner.nextInt()
    val size = Math.cbrt(population.toDouble())
    println(size.toInt())


}