package fr.elgregos.guitar

val scale = arrayOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")

class NoteMatrix {
    val matrix = HashMap<String, Array<String>>()

    init {
        scale.forEach {
            val values = Array<String>(12, { i -> calc(it, i) })
            matrix[it] = values
        }
    }
	
	fun calc(note: String, interval: Int) : String {
		val pos = scale.indexOf("$note")
		return scale[(pos + interval) % 12] 
	}

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("\n   ")
        for (i in 0..11) if (i<10) stringBuilder.append("    $i") else stringBuilder.append("   $i")
        matrix.toSortedMap().entries.forEach {
            stringBuilder.append("\n${if(it.key.length == 1) it.key+' ' else it.key} ")
            it.value.forEach { stringBuilder.append("   ${if(it.length==1) ' ' + it else it}") }
        }
        return stringBuilder.toString()
    }
}
