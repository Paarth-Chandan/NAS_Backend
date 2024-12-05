package org.workspace.nas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workspace.nas_backend.model.Response;
import org.workspace.nas_backend.service.ResponseService;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveResponse(@RequestBody Response response) {
        Response savedResponse = responseService.saveResponse(response);
        return ResponseEntity.ok(savedResponse);
    }
}
