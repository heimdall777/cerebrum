package ovh.cerebrum.cerebrumapp.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {


    @GetMapping("/api/hello")
    fun helloWorld() : String = "Hello world"
}