package fr.elgregos.guitar

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

/**
 * Created by BEVAN on 15/03/2017.
 */
@RestController
@RequestMapping("/game")
class GuitarStringsGameController {

	private val log = LoggerFactory.getLogger(GuitarStringsGameController::class.java)
	
	@PostConstruct
	fun init() {
		log.info(noteMatrix.toString())
	}


	@RequestMapping("/new-position")
	fun newPosition() = RandomPositionGenerator().getPosition()
}
