class Player(val id: Int, val name: String) {
    companion object {
        var role = "playable character"
    }

    fun getInfo(): String {
        return "$id, $name, $role"
    }
}

fun getPlayerInfo(player: Player) = player.getInfo()