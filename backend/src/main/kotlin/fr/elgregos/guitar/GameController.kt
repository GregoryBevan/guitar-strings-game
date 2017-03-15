package fr.elgregos.guitar

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

/**
 * Created by BEVAN on 15/03/2017.
 */
@RestController
class GuitarStringsGameController {

    private val log = LoggerFactory.getLogger(GuitarStringsGameController::class.java)

    val noteMatrix = NoteMatrix()

    @PostConstruct
    fun init() {
        log.info(noteMatrix.toString())
    }

    @RequestMapping("/new-position")
    fun newPosition() = Position(1, 1, "Fa")
}
