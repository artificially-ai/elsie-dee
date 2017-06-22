package nl.ekholabs.nlp.service;

import edu.cmu.sphinx.api.Configuration;
import org.springframework.stereotype.Service;

@Service
public class SpeechToTextService {

  public String processSpeech(final byte [] input) {
    final Configuration configuration = new Configuration();
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");


    return null;
  }
}
