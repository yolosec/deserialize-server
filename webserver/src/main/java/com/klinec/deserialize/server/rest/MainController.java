package com.klinec.deserialize.server.rest;

import com.klinec.deserialize.server.api.response.ErrorResponse;
import com.klinec.deserialize.server.api.response.GeneralResponse;
import com.klinec.deserialize.server.api.response.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLDecoder;
import java.util.Base64;

/**
 * Created by dusanklinec on 01.09.16.
 */
@RestController
public class MainController {
    private final static Logger LOG = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/suffer", method = RequestMethod.POST, consumes = "text/plain")
    public GeneralResponse rawRequest(@RequestBody String request) throws Exception {
        return deserialize(request);
    }

    @RequestMapping(value = "/suffer", method = RequestMethod.POST)
    public GeneralResponse rawRequest2(@RequestBody String request) throws Exception {
        return deserialize(request);
    }

    @RequestMapping(value = "/suffer/{req}", method = RequestMethod.GET)
    public GeneralResponse rawRequestGet(@PathVariable(value = "req") String request) throws Exception {
        return deserialize(request);
    }

    public GeneralResponse deserialize(String request) throws IOException {
        byte[] decoded = null;
        String urlDecoded = "";
        try {
            // URL friendly request?
            urlDecoded = URLDecoder.decode(request, "UTF-8");
            urlDecoded = urlDecoded
                    .replace(" ", "+")
                    .replace('-', '+')
                    .replace('_', '/')
                    .replace("=", "");
            LOG.info("Payload: " + request);
            decoded = Base64.getDecoder().decode(urlDecoded);

        } catch(Exception e){
            LOG.error("Base64 decoded: " + urlDecoded);
            LOG.error("Base64 decoding exception: " + request, e);
            return new ErrorResponse("Base64 error");
        }

        if (decoded == null || decoded.length == 0){
            return new ErrorResponse("Nothing to deserialize");
        }

        // Deserialization magic
        ByteArrayInputStream bis = new ByteArrayInputStream(decoded);
        ObjectInputStream in = new ObjectInputStream(bis);
        LOG.info("Going to deserialize...");

        try {
            final Object obj = in.readObject();
            LOG.info("Deserialized");

            if (obj == null){
                LOG.info("Deserialized: null");
                return new ResultResponse();
            }

            LOG.info("Obj: " + obj.getClass().getCanonicalName());
            LOG.info("Deserialized: " + obj);

        } catch(Exception e){
            LOG.error("Deserialization exception", e);
        }

        return new ResultResponse();
    }

    @RequestMapping(value = "string")
    public String serializeString(@RequestParam String input) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(input);
        byte[] yourBytes = bos.toByteArray();
        return Base64.getEncoder().encodeToString(yourBytes);
    }

}
