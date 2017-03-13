package fr.elgregos.guitar

val strings = mapOf(1 to 'E', 2 to 'A', 3 to 'D', 4 to 'G', 5 to 'B', 6 to 'E')

fun createRandomPosition(): Position {
	return Position(1, 0, "Mi")
}

data class Position(val guitarString: Int, val fret: Int, val note: String)
