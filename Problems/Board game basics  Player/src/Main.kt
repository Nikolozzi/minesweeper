class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var uniqueId = 0
        fun create(name: String): Player {
            return Player(id = uniqueId++, name, hp = 100)
        }
    }
}