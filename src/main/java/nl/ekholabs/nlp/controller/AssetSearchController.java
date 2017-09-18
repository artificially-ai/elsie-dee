package nl.ekholabs.nlp.controller;

import java.util.List;

import nl.ekholabs.nlp.client.ElsieDeeSearchAssetsFeignClient;
import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.AssetDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class AssetSearchController {

  private final static Logger LOGGER = LoggerFactory.getLogger(AssetSearchController.class);

  private final ElsieDeeSearchAssetsFeignClient elsieDeeSearchAssetsFeignClient;

  @Autowired
  public AssetSearchController(final ElsieDeeSearchAssetsFeignClient elsieDeeSearchAssetsFeignClient) {
    this.elsieDeeSearchAssetsFeignClient = elsieDeeSearchAssetsFeignClient;
  }

  @PostMapping(value = "/assets", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  public List<Asset> assets(final @RequestBody AssetDetails assetDetails) {
    LOGGER.info("AssetDetails received: {}", assetDetails);
    return elsieDeeSearchAssetsFeignClient.assets(assetDetails);
  }
}
