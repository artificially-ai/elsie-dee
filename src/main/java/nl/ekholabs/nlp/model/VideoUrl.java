package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.*;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class VideoUrl {

  private String url;

  VideoUrl() {
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final VideoUrl videoUrl = (VideoUrl) o;

    return url != null ? url.equals(videoUrl.url) : videoUrl.url == null;
  }

  @Override
  public int hashCode() {
    return url != null ? url.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "VideoUrl{" +
        "url='" + url + '\'' +
        '}';
  }
}
