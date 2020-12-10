import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val nums = IntArray(n)
    for (i in 0..nums.lastIndex) {
        nums[i] = scanner.nextInt()
    }

    val shift = scanner.nextInt() % n
    val shiftedNums = nums.drop(n - shift).plus(nums.take(n - shift))
    shiftedNums.forEach {
        print("$it ")
    }
}