package nl.ekholabs.nlp.client;

import java.util.List;

import nl.ekholabs.nlp.model.Asset;
import nl.ekholabs.nlp.model.AssetKeyword;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(serviceId = "elsie-dee-search")
public interface ElsieDeeSearchFeignClient {

  @RequestMapping(
      value = "/elsie-dee-search/assets",
      method = RequestMethod.POST,
      produces = APPLICATION_JSON_UTF8_VALUE
  )
  @ResponseBody
  List<Asset> assets(final AssetKeyword assetKeyword);
}