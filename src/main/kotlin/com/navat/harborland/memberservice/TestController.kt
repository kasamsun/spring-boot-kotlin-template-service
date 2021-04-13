package com.navat.harborland.memberservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class TestController {

    var log: Logger = LoggerFactory.getLogger(TestController::class.java)

    @RequestMapping("/testlog")
    fun testLog(): String {
        log.trace("A TRACE Message")
        log.debug("A DEBUG Message")
        log.info("An INFO Message")
        log.warn("A WARN Message")
        log.error("An ERROR Message")
        log.info("Example log from {}", TestController::class.java.simpleName)
        val message = "This is a String"
        val zero = 0
        try {
            log.debug("Logging message: {}", message)
            log.debug("Going to divide {} by {}", 42, zero)
            val result = 42 / zero
            log.debug("Result = {}", result)
        } catch (e: Exception) {
            log.error("Error dividing {} by {} ", 42, zero, e)
        }
        return "Hello, this is testlog. See console log"
    }

    @RequestMapping("/hello")
    @ResponseBody
    fun hello(): String {
        return "Hello World"
    }
}