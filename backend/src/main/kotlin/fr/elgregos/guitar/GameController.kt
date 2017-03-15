package fr.elgregos.guitar

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by BEVAN on 15/03/2017.
 */
@RestController
class GuitarStringsGameController {

    @RequestMapping("/new-position")
    fun newPosition() = Position(1, 1, "Fa")
}
