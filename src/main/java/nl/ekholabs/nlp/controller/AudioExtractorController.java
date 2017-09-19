package nl.ekholabs.nlp.controller;

import java.io.IOException;

import nl.ekholabs.nlp.client.ElsieDeeAudioRipFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class AudioExtractorController {

  private final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient;

  @Autowired
  public AudioExtractorController(final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient) {
    this.elsieDeeAudioRipFeignClient = elsieDeeAudioRipFeignClient;
  }

  @PostMapping(path = "/extractAudio", consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<byte[]> extractAudio(final @RequestParam(value = "video") MultipartFile videoFile) throws IOException {
    return elsieDeeAudioRipFeignClient.extractAudio(videoFile);
  }
}
