package nl.ekholabs.nlp.client.configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TextSupportConfig {

  @Bean
  @Scope("prototype")
  public Encoder feignTextEncoder() {
    return new SpringFormEncoder();
  }
}
