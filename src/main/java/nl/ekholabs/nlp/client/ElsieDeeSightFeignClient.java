package nl.ekholabs.nlp.client;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@FeignClient(serviceId = "elsie-deesight", configuration = MultipartSupportConfig.class)
public interface ElsieDeeSightFeignClient {

  @RequestMapping(
      value = "/elsie-deesight/process",
      method = RequestMethod.POST,
      produces = APPLICATION_OCTET_STREAM_VALUE
  )
  @ResponseBody
  ResponseEntity<byte[]> process(final @RequestPart MultipartFile image);
}

@Configuration
class MultipartSupportConfig {

  @Bean
  @Primary
  @Scope("prototype")
  public Encoder feignFormEncoder() {
    return new SpringFormEncoder();
  }
}