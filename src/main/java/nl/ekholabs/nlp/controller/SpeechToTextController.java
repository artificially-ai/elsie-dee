package nl.ekholabs.nlp.controller;

import java.io.IOException;

import nl.ekholabs.nlp.model.TextResponse;
import nl.ekholabs.nlp.service.SpeechToTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class SpeechToTextController {

  private final SpeechToTextService speechToTextService;

  @Autowired
  public SpeechToTextController(final SpeechToTextService speechToTextService) {
    this.speechToTextService = speechToTextService;
  }

  @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
  public TextResponse process(final @RequestParam(value = "file") MultipartFile fileToProcess) throws IOException {

    final String outputText = speechToTextService.processSpeech(fileToProcess.getBytes());
    return new TextResponse(outputText);
  }
}
