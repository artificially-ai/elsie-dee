package nl.ekholabs.nlp.controller;

import java.io.IOException;

import nl.ekholabs.nlp.client.ElsieDeeAudioRipFeignClient;
import nl.ekholabs.nlp.client.ElsieDeetectFeignClient;
import nl.ekholabs.nlp.model.Language;
import nl.ekholabs.nlp.model.TextResponse;
import nl.ekholabs.nlp.service.SpeechToTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class ChainReactionController {

  private final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient;
  private final SpeechToTextService speechToTextService;
  private final ElsieDeetectFeignClient elsieDeetect;

  @Autowired
  public ChainReactionController(final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient,
                                 final SpeechToTextService speechToTextService, final ElsieDeetectFeignClient elsieDeetect) {
    this.elsieDeeAudioRipFeignClient = elsieDeeAudioRipFeignClient;
    this.speechToTextService = speechToTextService;
    this.elsieDeetect = elsieDeetect;
  }

  @PostMapping(path = "/executeChain", produces = APPLICATION_JSON_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
  public TextResponse executeChain(final @RequestParam(value = "video") MultipartFile videoFile) throws IOException {

    //TODO replace with chain of responsibility design pattern.
    final ResponseEntity<byte[]> audioEntity = elsieDeeAudioRipFeignClient.process(videoFile);
    final String outputText = speechToTextService.processSpeech(audioEntity.getBody());
    final Language language = elsieDeetect.identify(outputText);

    return new TextResponse(language, outputText);
  }
}
