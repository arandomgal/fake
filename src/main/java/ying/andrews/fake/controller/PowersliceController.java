package ying.andrews.fake.controller;

import org.apache.coyote.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
public class PowersliceController {

    @GetMapping("/api/v1/version")
    public String version(@RequestParam(value = "client_id", defaultValue = "12453") String clientId) {
        return "{\"version_universal_grid\":\"2.3\",\"version_powerslice\":\"0.1.1\"}";
    }

    @GetMapping("/api/v1/delete")
    public String delete(@RequestParam(value = "client_id", defaultValue = "12453") String clientId,
                           @RequestParam(value = "days", defaultValue = "30") String days) throws BadRequestException {
//        return "{\"success\": false}";
        throw new BadRequestException("Bad request.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.class)
    public String return400(HttpClientErrorException ex) {
        return ex.getMessage();
    }
}
