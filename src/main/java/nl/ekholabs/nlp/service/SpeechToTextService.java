package nl.ekholabs.nlp.service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;

@Service
public class SpeechToTextService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpeechToTextService.class.getName());

  public String processSpeech(final byte [] input) throws IOException {
    final Configuration configuration = new Configuration();
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

    final StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
    final InputStream stream = new FileInputStream(valueOf(new ByteArrayInputStream(input)));

    recognizer.startRecognition(stream);
    SpeechResult result;

    final StringBuilder output = new StringBuilder();
    while ((result = recognizer.getResult()) != null) {
      result.getWords().stream().forEach(wordResult -> {
        output.append(wordResult.getWord().getSpelling())
            .append(' ');
      });

      LOGGER.info("Hypothesis: %s",  result.getHypothesis());
    }
    recognizer.stopRecognition();

    return output.toString();
  }
}
