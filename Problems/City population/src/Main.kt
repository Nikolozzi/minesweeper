class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = if (value < 0) 0 else if (value > maxPopulation) maxPopulation else value
        }

    val maxPopulation: Int = 50_000_000
}