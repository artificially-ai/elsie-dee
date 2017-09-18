package nl.ekholabs.nlp.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ekholabs.nlp.client.ElsieDeeAudioRipFeignClient;
import nl.ekholabs.nlp.client.ElsieDeeCreateAssetFeignClient;
import nl.ekholabs.nlp.client.ElsieDeeSearchAssetsFeignClient;
import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.AssetDetails;
import nl.ekholabs.nlp.model.Subtitles;
import nl.ekholabs.nlp.service.SpeechToTextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private final static Logger LOGGER = LoggerFactory.getLogger(ChainReactionController.class);

  private final SpeechToTextService speechToTextService;
  private final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient;
  private final ElsieDeeCreateAssetFeignClient elsieDeeCreateAssetFeignClient;
  private final ElsieDeeSearchAssetsFeignClient elsieDeeSearchAssetsFeignClient;

  @Autowired
  public ChainReactionController(final SpeechToTextService speechToTextService,
                                 final ElsieDeeAudioRipFeignClient elsieDeeAudioRipFeignClient,
                                 final ElsieDeeCreateAssetFeignClient elsieDeeCreateAssetFeignClient,
                                 final ElsieDeeSearchAssetsFeignClient elsieDeeSearchAssetsFeignClient) {
    this.speechToTextService = speechToTextService;
    this.elsieDeeAudioRipFeignClient = elsieDeeAudioRipFeignClient;
    this.elsieDeeCreateAssetFeignClient = elsieDeeCreateAssetFeignClient;
    this.elsieDeeSearchAssetsFeignClient = elsieDeeSearchAssetsFeignClient;
  }

  @PostMapping(path = "/processVideo", produces = APPLICATION_JSON_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
  public List<Asset> processVideo(final @RequestParam(value = "title") String assetTitle,
                           final @RequestParam(value = "keywords") String assetKeywordText,
                           final @RequestParam(value = "video") MultipartFile videoFile) throws IOException {

    //TODO replace with chain of responsibility design pattern.
    final ResponseEntity<byte[]> audioEntity = elsieDeeAudioRipFeignClient.extractAudio(videoFile);
    final Subtitles subtitles = new Subtitles(speechToTextService.processSpeech(audioEntity.getBody()));

    final Asset asset = elsieDeeCreateAssetFeignClient.createAsset(assetTitle, subtitles);
    LOGGER.info("Asset created: {}", asset);

    final AssetDetails assetDetails = new ObjectMapper().readValue(assetKeywordText, AssetDetails.class);
    LOGGER.info("AssetDetails created: {}", assetDetails);

    return elsieDeeSearchAssetsFeignClient.assets(assetDetails);
  }
}
