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
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_input", nullable = false)
    private String userInput;

    @Column(name = "question1")
    private String question1;

    @Column(name = "question2")
    private String question2;

    @Column(name = "question3")
    private String question3;

    @Column(name = "question4")
    private String question4;
}
