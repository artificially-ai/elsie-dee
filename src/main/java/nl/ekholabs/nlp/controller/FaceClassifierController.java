package nl.ekholabs.nlp.controller;

import java.io.IOException;

import nl.ekholabs.nlp.client.ElsieDeeSightFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class FaceClassifierController {

  private final ElsieDeeSightFeignClient elsieDeeSightFeignClient;

  @Autowired
  public FaceClassifierController(final ElsieDeeSightFeignClient elsieDeeSightFeignClient) {
    this.elsieDeeSightFeignClient = elsieDeeSightFeignClient;
  }

  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<byte[]> processImage(final @RequestParam(value = "image") MultipartFile face) throws IOException {
    return elsieDeeSightFeignClient.process(face);
  }

}
