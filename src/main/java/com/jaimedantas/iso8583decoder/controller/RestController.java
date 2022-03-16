package com.jaimedantas.iso8583decoder.controller;

import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.message.ResponseSingleTransaction;
import com.jaimedantas.iso8583decoder.processor.ProcessDataElement108;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping(path="/decoder/de108")
@Api("Decoder of Data Element 108 of ISO 8583 messages")
public class RestController {

    @Autowired
    ProcessDataElement108 processor;

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @ApiOperation("Decodes the Data Element 108 of a single transaction")
    @PostMapping(path="/transaction", produces = "application/json")
    public ResponseEntity<?> decodeDataElement108 (@RequestParam String dataElement108) throws DecodeException {

        logger.info("Received request id {}", MDC.get("CorrelationId"));

        ResponseEntity<?> response =  processor.process(dataElement108);

        logger.info("Processed request id {}", MDC.get("CorrelationId"));

        return response;
    }

    @ApiOperation("Decodes a txt file with multiple Data Elements 108 in each line")
    @PostMapping(path="/file", produces = "application/json")
    public ResponseEntity<ArrayList<ResponseSingleTransaction>> decodeDataElement108File (@RequestParam MultipartFile dataElement108File) throws DecodeException, IOException {

        logger.info("Received request id {}", MDC.get("CorrelationId"));

        ResponseEntity<ArrayList<ResponseSingleTransaction>> response =  processor.processFile(dataElement108File);

        logger.info("Processed request id {}", MDC.get("CorrelationId"));

        return response;
    }



}
