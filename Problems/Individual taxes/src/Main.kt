import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val incomes = DoubleArray(n) { scanner.nextDouble() }
    val taxes = ByteArray(n) { scanner.nextByte() } // % of a company's income

    var maxTax = -1.0
    var maxTaxInd = -1
    for (i in incomes.indices) {
        val tax = incomes[i] * taxes[i] / 100
        if (tax > maxTax) {
            maxTax = tax
            maxTaxInd = i + 1
        }
    }

    println(maxTaxInd)
}