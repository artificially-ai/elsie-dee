package nl.ekholabs.nlp.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import nl.ekholabs.nlp.client.ElsieDeetectFeignClient;
import nl.ekholabs.nlp.model.Language;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static java.lang.ClassLoader.getSystemResource;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SpeechToTextControllerTest {

  private static final Logger LOGGER = Logger.getLogger(SpeechToTextControllerTest.class.getName());

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ElsieDeetectFeignClient elsieDeetect;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test
  public void processAudioFile() throws Exception {

    final String expectedResult = "{\"output\":\"<sil> the catch was crowded <sil> goes inside and "
        + "out [NOISE] <sil> with passengers who buy that toll it seemed principally bonds to the mentions a bit \"}";

    final byte[] allBytes = Files.readAllBytes(Paths.get(getSystemResource("man2_orig.wav").toURI()));

    final MockMultipartFile multipartFile =
        new MockMultipartFile("audio", "man2_orig.wav", "audio/wav", allBytes);

    when(elsieDeetect.identify("<sil> the catch was crowded <sil> goes inside and out [NOISE] <sil> with "
        + "passengers who buy that toll it seemed principally bonds to the mentions a bit ")).thenReturn(new Language("en"));

    final String contentAsString = mvc.perform(fileUpload("/processAudio").file(multipartFile))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    LOGGER.info(contentAsString);

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.equalTo(expectedResult));
  }

  @Test
  public void identifyEnglish() throws Exception {

    final String content = "If you just want the body of the xhtml document, without the header, you can chain together a "
        + "BodyContentHandler and a ToXMLContentHandler as shown:";

    final RequestBuilder request = post("/identify")
        .contentType(TEXT_PLAIN_VALUE)
        .content(content);

    when(elsieDeetect.identify(content)).thenReturn(new Language("en"));

    final String contentAsString = mvc.perform(request)
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.containsString("en"));

    LOGGER.info(contentAsString);
  }
}