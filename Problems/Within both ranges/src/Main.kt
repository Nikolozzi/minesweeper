import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val nums = MutableList(5) {
        scanner.nextInt()
    }

    println(nums[4] in nums[0]..nums[1] && nums[4] in nums[2]..nums[3])
}