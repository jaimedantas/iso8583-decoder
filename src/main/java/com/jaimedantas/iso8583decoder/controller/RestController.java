package com.jaimedantas.iso8583decoder.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(path="/decoder/de108")
@Api("Decoder of Data Element 108 of ISO 8583 messages")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @ApiOperation("Decodes the Data Element 108 of a single transaction")
    @PostMapping(path="/transaction", produces = "application/json", consumes = "application/json")
    public @ResponseBody String decodeDataElement108 (@RequestParam String dataElement108) {
        logger.info("Received request id {}", MDC.get("CorrelationId"));
        return "teste";
    }



}
