package nl.ekholabs.nlp.client.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class JsonSupportConfig {

  @Bean
  @Scope("prototype")
  public Encoder feignEncoder() {
    final HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
    final ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
    return new SpringEncoder(objectFactory);
  }

  public ObjectMapper customObjectMapper(){
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper;
  }
}
