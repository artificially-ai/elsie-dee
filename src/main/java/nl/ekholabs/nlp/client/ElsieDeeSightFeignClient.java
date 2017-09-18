package nl.ekholabs.nlp.client;

import nl.ekholabs.nlp.client.configuration.MultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@FeignClient(serviceId = "elsie-deesight", configuration = MultipartSupportConfig.class)
public interface ElsieDeeSightFeignClient {

  @RequestMapping(
      value = "/elsie-deesight/classifyImage",
      method = RequestMethod.POST,
      produces = APPLICATION_OCTET_STREAM_VALUE
  )
  ResponseEntity<byte[]> classifyImage(final @RequestPart MultipartFile image);
}