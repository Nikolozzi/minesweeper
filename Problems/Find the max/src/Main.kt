import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val nums = IntArray(n) { scanner.nextInt() }

    var maxElement = Int.MIN_VALUE
    var firstMaxInd = -1
    for (i in nums.indices) {
        if (nums[i] > maxElement) {
            maxElement = nums[i]
            firstMaxInd = i
        }
    }

    println(firstMaxInd)
}