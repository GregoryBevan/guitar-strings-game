package fr.elgregos.guitar

import java.util.Random
import java.security.SecureRandom
import org.slf4j.LoggerFactory

val guitarStrings = mapOf(1 to "E", 2 to "A", 3 to "D", 4 to "G", 5 to "B", 6 to "E")
val noteMatrix = NoteMatrix()

class RandomPositionGenerator(private val random: Random = SecureRandom()) {
	init {
	}

	fun getPosition(): Position {
		val guitarString = guitarStrings[random.nextInt(5) + 1]
		val fret = random.nextInt(11)
		return Position(guitarString, fret, noteMatrix.matrix[guitarString]?.get(fret))
	}
}


data class Position(val guitarString: String?, val fret: Int, val note: String?)
