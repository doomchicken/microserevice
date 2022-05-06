package com.greg.microserviceappkotlin.web

import com.greg.microsservice.shared.client.TextDoublerClient
import com.greg.microsservice.shared.model.TextDoubleRequest
import com.greg.microsservice.shared.model.TextDoubleResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.lang.InterruptedException
import java.lang.RuntimeException
import javax.validation.Valid

@RestController
@RequestMapping("/home")
class TextDoublerController : TextDoublerClient {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    @PostMapping("text-double")
    override fun hello(@RequestBody textDoubleRequest: @Valid TextDoubleRequest): TextDoubleResult {
        log.info("Message recieved " + textDoubleRequest.text())
        return TextDoubleResult(textDoubleRequest.text() + textDoubleRequest.text())
    }

    @GetMapping("test-error")
    override fun testError() {
        val num = 10/0;
        return;
    }

    @GetMapping("delay")
    override fun delay(@RequestParam("milliseconds") milliseconds: Int) {
        try {
            Thread.sleep(milliseconds.toLong())
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }
    }
}