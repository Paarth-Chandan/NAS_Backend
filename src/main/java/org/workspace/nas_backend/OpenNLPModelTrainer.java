package org.workspace.nas_backend;

import opennlp.tools.doccat.*;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OpenNLPModelTrainer {
    public static void main(String[] args) {
        try {
            // Input training data
            InputStreamFactory inputStreamFactory = () -> new FileInputStream("src/main/java/org/workspace/nas_backend/training-data.txt");

            try (ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
                 ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream)) {

                // Training parameters
                TrainingParameters params = new TrainingParameters();
                params.put(TrainingParameters.ITERATIONS_PARAM, 100);
                params.put(TrainingParameters.CUTOFF_PARAM, 1);

                // Train the model
                DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, new DoccatFactory());

                // Save the model to a file
                try (OutputStream modelOut = new BufferedOutputStream(new FileOutputStream("sentiment-model.bin"))) {
                    model.serialize(modelOut);
                }

                System.out.println("Model training complete. Model saved as sentiment-model.bin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
