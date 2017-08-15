package nl.ekholabs.nlp.client;

import nl.ekholabs.nlp.client.configuration.MultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@FeignClient(serviceId = "elsie-dee-audiorip", configuration = MultipartSupportConfig.class)
public interface ElsieDeeAudioRipFeignClient {

  @RequestMapping(
      value = "/elsie-dee-audiorip/ripAudio",
      method = RequestMethod.POST,
      produces = APPLICATION_OCTET_STREAM_VALUE
  )
  @ResponseBody
  ResponseEntity<byte[]> process(final @RequestPart MultipartFile video);
}