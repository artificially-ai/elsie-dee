package nl.ekholabs.nlp.controller;

import java.util.List;

import nl.ekholabs.nlp.client.ElsieDeeSearchFeignClient;
import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.AssetKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class AssetSearchController {

  private final ElsieDeeSearchFeignClient elsieDeeSightFeignClient;

  @Autowired
  public AssetSearchController(final ElsieDeeSearchFeignClient elsieDeeSightFeignClient) {
    this.elsieDeeSightFeignClient = elsieDeeSightFeignClient;
  }

  @PostMapping(value = "/assets", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
  public List<Asset> assets(@RequestBody final AssetKeyword assetKeyword) {
    return elsieDeeSightFeignClient.assets(assetKeyword);
  }
}
