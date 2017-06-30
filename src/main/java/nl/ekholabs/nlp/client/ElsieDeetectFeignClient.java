package nl.ekholabs.nlp.client;

import nl.ekholabs.nlp.model.Language;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(serviceId = "elsie-deetect")
public interface ElsieDeetectFeignClient {

  @RequestMapping(path = "elsie-deetect/identify", method = POST, produces = APPLICATION_JSON_UTF8_VALUE)
  Language identify(@RequestBody final String text);

}
