package nl.ekholabs.nlp.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.ClassLoader.getSystemResource;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SpeechToTextControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void shouldSaveUploadedFile() throws Exception {

    final String expectedResult = "{\"output\":\"<sil> the catch was crowded <sil> goes inside and out [NOISE] <sil> with "
        + "passengers who buy that toll it seemed principally bonds to the mentions a bit \"}";

    final byte[] allBytes = Files.readAllBytes(Paths.get(getSystemResource("man2_orig.wav").toURI()));

    final MockMultipartFile multipartFile =
        new MockMultipartFile("input", "man2_orig.wav", "audio/wav", allBytes);

    final String contentAsString = this.mvc.perform(fileUpload("/process").file(multipartFile))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertThat(contentAsString, Matchers.notNullValue());
    assertThat(contentAsString, Matchers.equalTo(expectedResult));
  }
}