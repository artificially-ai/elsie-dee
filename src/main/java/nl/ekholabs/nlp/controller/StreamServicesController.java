package nl.ekholabs.nlp.controller;

import nl.ekholabs.nlp.client.StreamServicesFeignClient;
import nl.ekholabs.nlp.model.Streams;
import nl.ekholabs.nlp.model.VideoUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class StreamServicesController {

  private final StreamServicesFeignClient streamServicesFeignClient;

  @Autowired
  public StreamServicesController(final StreamServicesFeignClient streamServicesFeignClient) {
    this.streamServicesFeignClient = streamServicesFeignClient;
  }

  @PostMapping(value = "/streamDetails", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  public Streams streamDetails(final @RequestBody VideoUrl videoUrl) {
    return streamServicesFeignClient.streamDetails(videoUrl);
  }
}
