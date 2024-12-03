package org.workspace.nas_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.workspace.nas_backend.model.MLResponseEntity;
import org.workspace.nas_backend.repository.ResponseRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class MLService {

    private static final String ML_MODEL_URL = "https://8521-34-80-208-72.ngrok-free.app/generate";

    @Autowired
    private ResponseRepository responseRepository;

    public MLResponseEntity fetchAndSaveResponse(String userInput) {
        // Prepare the request body
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("input", userInput);

        // Make the POST request to the ML model
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> response = restTemplate.postForObject(ML_MODEL_URL, requestBody, Map.class);

        // Extract the model's output
        String modelResponse = response != null ? response.get("output") : "No response from model";

        // Save to the database
        MLResponseEntity entity = new MLResponseEntity();
        entity.setUserInput(userInput);
        entity.setModelResponse(modelResponse);
        return responseRepository.save(entity);
    }
}
