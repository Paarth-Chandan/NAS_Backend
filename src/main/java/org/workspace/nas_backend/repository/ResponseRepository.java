package org.workspace.nas_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workspace.nas_backend.model.MLResponseEntity;

@Repository
public interface ResponseRepository extends JpaRepository<MLResponseEntity, Integer> {
}
