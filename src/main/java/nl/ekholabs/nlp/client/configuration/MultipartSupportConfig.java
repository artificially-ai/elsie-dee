package nl.ekholabs.nlp.client.configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MultipartSupportConfig {

  @Bean
  @Primary
  @Scope("prototype")
  public Encoder feignFormEncoder() {
    return new SpringFormEncoder();
  }
}
