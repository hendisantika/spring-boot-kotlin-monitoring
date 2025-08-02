package id.my.hendisantika.monitoring

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class SpringBootKotlinMonitoringApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinMonitoringApplication>(*args)
}

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    @ExceptionHandler(RuntimeException::class)
    fun customerNotFound(exception: RuntimeException) {
        logger.error(exception) { "Exception" }
    }
}

@RestController
@RequestMapping("/message")
class MessageController(val meterRegistry: MeterRegistry) {

    private val logger = KotlinLogging.logger {}


}
