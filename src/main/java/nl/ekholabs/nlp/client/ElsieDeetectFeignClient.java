package nl.ekholabs.nlp.client;

import nl.ekholabs.nlp.client.configuration.TextSupportConfig;
import nl.ekholabs.nlp.model.Language;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@FeignClient(serviceId = "elsie-deetect", configuration = TextSupportConfig.class)
public interface ElsieDeetectFeignClient {

  @PostMapping(path = "/elsie-deetect/idLanguage",
      consumes = TEXT_PLAIN_VALUE,
      produces = APPLICATION_JSON_UTF8_VALUE)
  Language idLanguage(@RequestBody final String text);

}
