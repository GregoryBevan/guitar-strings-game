package fr.elgregos.guitar

val notes = mapOf('A' to "La", 'B' to "Si", 'C' to "Do", 'D' to "Ré", 'E' to "Mi", 'F' to "Fa", 'G' to "Sol")

class NoteMatrix {
    val matrix = HashMap<Char, CharArray>()

    init {
        notes.keys.forEach {
            val values = CharArray(12)
            for (i in 0..11) {
                values[i] = 'A'
            }
            matrix[it] = values
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("\n    ")
        for (i in 0..11) if (i<10) stringBuilder.append("  $i") else stringBuilder.append(" $i")
        matrix.entries.forEach {
            stringBuilder.append("\n${it.key} : ")
            it.value.forEach { stringBuilder.append("  $it") }
        }
        return stringBuilder.toString()
    }
}
