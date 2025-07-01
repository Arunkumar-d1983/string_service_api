package com.example.string_service_api.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.string_service_api.dto.ErrorResponse;
import com.example.string_service_api.dto.RemoveResponse;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/remove")
    public ResponseEntity<?> removeFirstAndLast(@RequestParam(value = "input", required = false) String paramInput,
            HttpServletRequest request) {
        String rawQuery = request.getQueryString();
        String input = extractRawInputFromQuery(rawQuery);
        if (input == null) {
            input = paramInput;
        }
        if (input == null || input.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Input must be at least 2 characters."));
        } else if (input.length() == 2) {
            return ResponseEntity.ok(new RemoveResponse(input, ""));
        } else {
            String result = StringUtils.substring(input, 1, input.length() - 1);
            return ResponseEntity.ok(new RemoveResponse(input, result));
        }
    }

    private String extractRawInputFromQuery(String query) {
        if (query == null || !query.startsWith("input="))
            return null;
        return query.substring("input=".length());
    }
}