package nl.ekholabs.nlp.client;

import nl.ekholabs.nlp.client.configuration.JsonSupportConfig;
import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.Subtitles;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(serviceId = "elsie-dee-search", configuration = JsonSupportConfig.class)
public interface ElsieDeeCreateAssetFeignClient {

  @RequestMapping(
      value = "/elsie-dee-search/createAsset/{title}",
      method = RequestMethod.POST,
      consumes = APPLICATION_JSON_UTF8_VALUE,
      produces = APPLICATION_JSON_UTF8_VALUE
  )
  Asset createAsset(final @PathVariable(value = "title") String assetTitle, final @RequestBody Subtitles subtitles);
}