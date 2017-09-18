package nl.ekholabs.nlp.client;

import java.util.List;

import nl.ekholabs.nlp.client.configuration.JsonSupportConfig;
import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.AssetDetails;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(serviceId = "elsie-dee-search", configuration = JsonSupportConfig.class)
public interface ElsieDeeSearchAssetsFeignClient {

  @RequestMapping(
      value = "/elsie-dee-search/assets",
      method = RequestMethod.POST,
      consumes = APPLICATION_JSON_UTF8_VALUE,
      produces = APPLICATION_JSON_UTF8_VALUE
  )
  List<Asset> assets(final @RequestBody AssetDetails assetDetails);

}