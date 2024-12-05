package org.workspace.nas_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workspace.nas_backend.model.Response;
import org.workspace.nas_backend.repository.ResponseRepository;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }
}
