package nl.ekholabs.nlp.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import nl.ekholabs.nlp.client.ElsieDeeSightFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import static java.lang.ClassLoader.getSystemResource;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FaceClassifierControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ElsieDeeSightFeignClient elsieDeeSight;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test
  public void processImage() throws Exception {
    final byte[] expected = Files.readAllBytes(Paths.get(getSystemResource("elsie-deesight-predicted-test-image.png").toURI()));
    final byte[] allBytes = Files.readAllBytes(Paths.get(getSystemResource("elsie-dee-sight-test-image.jpg").toURI()));

    final MockMultipartFile multipartFile =
        new MockMultipartFile("image", "elsie-dee-sight-test-image.jpg", "image/jpeg", allBytes);

    MultiValueMap<String, String> headers = new HttpHeaders();

    when(elsieDeeSight.classifyImage(multipartFile)).thenReturn(new ResponseEntity<>(expected, headers, HttpStatus.OK));

    mvc.perform(fileUpload("/classifyImage").file(multipartFile))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsByteArray();
  }
}