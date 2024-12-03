package org.workspace.nas_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "responses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MLResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Use Integer instead of int for compatibility

    @Column(nullable = false)
    private String userInput;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String modelResponse;
}
