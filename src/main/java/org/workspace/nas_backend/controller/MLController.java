package org.workspace.nas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workspace.nas_backend.model.MLResponseEntity;
import org.workspace.nas_backend.service.MLService;

import java.util.Map;

@RestController
@RequestMapping("/api/ml")
public class MLController {

    @Autowired
    private MLService mlService;

    @PostMapping("/generate")
    public ResponseEntity<MLResponseEntity> generateAndSaveResponse(@RequestBody Map<String, String> requestBody) {
        String userInput = requestBody.get("input");

        // Call the service to fetch and save the response
        MLResponseEntity savedResponse = mlService.fetchAndSaveResponse(userInput);

        // Return the saved response wrapped in a ResponseEntity
        return ResponseEntity.ok(savedResponse);
    }
}
